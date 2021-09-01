class Foo {

  private AtomicBoolean firstJobDone = new AtomicBoolean();
  private AtomicBoolean secondJobDone = new AtomicBoolean();

  public Foo() {}

  public void first(Runnable printFirst) throws InterruptedException {
    // printFirst.run() outputs "first".
    printFirst.run();
    // mark the first job as done, by increasing its count.
    firstJobDone.set(true);
  }

  public void second(Runnable printSecond) throws InterruptedException {
    while (firstJobDone.get() != true) {
      // waiting for the first job to be done.
    }
    // printSecond.run() outputs "second".
    printSecond.run();
    // mark the second as done, by increasing its count.
    secondJobDone.set(true);
  }

  public void third(Runnable printThird) throws InterruptedException {
    while (secondJobDone.get() != true) {
      // waiting for the second job to be done.
    }
    // printThird.run() outputs "third".
    printThird.run();
  }
}
