package threadingdemo;

import java.util.concurrent.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadingDemo {
    public static void main(String[] args) {
        performSequentialCalculation(); // make sure, all classloader-effects are gone...
        performParallelCalculation();

        long startInstantSequential = System.currentTimeMillis();
        performSequentialCalculation();
        long endInstantSequential = System.currentTimeMillis();
        long elapsedSequential = endInstantSequential - startInstantSequential;
        System.out.println("sequential computation took: " + elapsedSequential + "ms");

        long startInstantParallel = System.currentTimeMillis();
        performParallelCalculation();
        long endInstantParallel = System.currentTimeMillis();
        long elapsedParallel = endInstantParallel - startInstantParallel;
        System.out.println("parallel computation took: " + elapsedParallel + "ms");

        System.out.println(incrementJustAVariableInALoop(1000000));
        System.out.println(incrementJustAVariableInALoop(1000000));
        System.out.println(incrementJustAVariableInALoop(1000000));
        System.out.println(incrementJustAVariableInALoop(1000000));

        showAtomicityProblem();

        threadPool.shutdown();
    }

    private static void showAtomicityProblem() {
        justAVariable = 0L;
        for (int count = 0; count < 10; ++count) {
            completionService.submit(new Callable<Long>() {
                                         @Override
                                         public Long call() throws Exception {
                                             return incrementJustAVariableInALoop(1000000);
                                         }
                                     }
            );
        }

        for (int count = 0; count < 10; ++count) {
            try {
                completionService.take().get();
            } catch(InterruptedException | ExecutionException exc) {
                exc.printStackTrace();
            }
        }

        System.out.println("expecting justAVariable to be " + 10000000L +", and it is: " + justAVariable);
    }

    private static long justAVariable = 0L;
    private static void incrementJustAVariable() {
        ++justAVariable;
    }

    private static final Lock justAVariableLock = new ReentrantLock();

    private static void safelyIncrementJustAVariable() {
        justAVariableLock.lock();
        try {
            ++justAVariable;
        } finally {
            justAVariableLock.unlock();
        }

    }

    private static long incrementJustAVariableInALoop(int numIncrements) {
        while (numIncrements-- > 0)
            safelyIncrementJustAVariable();
        return justAVariable;
    }

    final static int numLoops = 10;
    final static long numValuesToSumUp = 200000000;

    private static void performSequentialCalculation() {
        for (int currentLoop = 0; currentLoop < numLoops; ++currentLoop)
            sumUpValues();
    }

    private static ExecutorService threadPool = Executors.newCachedThreadPool();
    private static ExecutorCompletionService<Long> completionService = new ExecutorCompletionService<Long>(threadPool);

    private static void performParallelCalculation() {
        for (int currentLoop = 0; currentLoop < numLoops; ++currentLoop)
            completionService.submit(new Callable<Long>() {
                                         @Override
                                         public Long call() throws Exception {
                                             return sumUpValues();
                                         }
                                     }
            );
        for (int currentLoop = 0; currentLoop < numLoops; ++currentLoop) {
            try {
                Future<Long> resultFuture = completionService.take();
                resultFuture.get();
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
    }

    private static long sumUpValues() {
        long result = 0L;
        for (long currentValue = 0L; currentValue < numValuesToSumUp; ++ currentValue)
            result += currentValue;
        return result;
    }
}
