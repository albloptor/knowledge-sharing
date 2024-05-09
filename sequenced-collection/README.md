<div align="center">

![sequenced-collections](https://github.com/albloptor/knowledge-sharing/assets/7635194/9ac58f14-b038-47e8-8a51-a067b3735e30)

</div>

# Sequenced collections
Introduction to the new Sequenced Collections introduced as part of Java 21.

The goal of the exercise is to make the tests in `ExercisesShould` pass using Java 17. After making them pass, we will upgrade to Java 21 and see if there's a nicer way to make them pass.

## Steps
1. Make sure you can build the project with Java 17: `./gradlew build`
2. The tests are all annotated with `@PendingFeature`, so they will all be ignored initially.
3. Remove the `@PendingFeature` annotation from all the tests in the class. Now all the tests should fail.
4. Go to the `Exercises` class and implement all the methods in order to make the tests pass.
5. Once all the tests are passing, upgrade to Java 21 by setting the javaToolchain version of the module to 21.
6. Try to find a nicer way to implement the previous methods.
