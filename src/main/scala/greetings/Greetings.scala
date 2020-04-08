package greetings

object Greetings {
  def greet(person: String*): String = {
    def isShouting(name: String): Boolean = {
      name.toUpperCase() == name
    }

    def concatenate(names: Seq[String]) = {
      s"${names.length match {
        case 1 => ""
        case 2 => s"${names.head} and "
        case _ => s"${names.init.mkString(", ")}, and "
      }}${names.last}"
    }

    if (person.isEmpty) return "Hello, my friend."

    val escaped = "^\"([^,]+),(.+)\"$".r
    val personsList = person
      .map(input => escaped.replaceAllIn(input, "$1#$2"))
      .flatMap(_.split(",").map(_.trim))
      .map(_.replace("#", ","))

    val (shout, normal) = personsList.partition(isShouting)

    s"${if (normal.nonEmpty) s"Hello, ${concatenate(normal)}." else ""}${if (shout.nonEmpty) s"${if (normal.nonEmpty) " AND " else ""}HELLO, ${concatenate(shout)}!" else ""}"
  }
}
