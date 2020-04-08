import greetings.Greetings
import org.scalatest.FunSuite

class GreetingTest extends FunSuite {
  test("Require the function") {
    assert(Greetings.greet("Bob") === "Hello, Bob.")
  }

  test("Act when name is null") {
    assert(Greetings.greet() === "Hello, my friend.")
  }

  test("Should manage shout") {
    assert(Greetings.greet("JERRY") === "HELLO, JERRY!")
  }

  test("Should manage two names") {
    assert(Greetings.greet("Jill", "Jane") === "Hello, Jill and Jane.")
  }

  test("Should manage several names") {
    assert(Greetings.greet("Amy", "Brian", "Charlotte") === "Hello, Amy, Brian, and Charlotte.")
  }

  test("Should shout to shouters") {
    assert(Greetings.greet("Amy", "BRIAN", "Charlotte") === "Hello, Amy and Charlotte. AND HELLO, BRIAN!")
  }

  test("Should separate names with comma") {
    assert(Greetings.greet("Bob", "Charlie, Dianne") === "Hello, Bob, Charlie, and Dianne.")
  }

  test("Should not separate names with comma if escaped") {
    assert(Greetings.greet("Bob", "\"Charlie, Dianne\"") === "Hello, Bob and Charlie, Dianne.")
  }
}