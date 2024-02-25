package contacts

import java.time.Instant
import java.time.ZoneId
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter
import kotlin.system.exitProcess

//val isPhoneNumber = Regex("\\+?(\\w+)?[-\\s]?\\(?(\\w{2,})?\\)?[-\\s]?(\\w{2,})?[-\\s]?(\\w{2,})?")
val isPhoneNumber = Regex(".+")
var time: ZonedDateTime = Instant.now().atZone(ZoneId.systemDefault())
val formatter: DateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss")

var contactsList: MutableList<Contacts> = mutableListOf()

// Creating a class Contacts
open class Contacts(var phoneNumber: String) {
    var timeCreated: String = formatter.format(time).toString()
    var timeEdited: String = ""

    init {
        println("The record added.")
    }

    fun timeEdit() {
        timeEdited = formatter.format(time).toString()
    }

    open fun displayRecord(chosenRecord: Contacts) {
        println("Number: $phoneNumber")
        println("Time created: $timeCreated")
        println("Time last edit: $timeEdited")
        println("")
        print("Enter action (edit, delete, menu): ")
        val action = readln().toString()
    }
}

class Person(phoneNumber: String) : Contacts(phoneNumber) {
    var name: String = ""
    var surname: String = ""
    var birthDate: String = ""
    var gender: String = ""

    fun displayRecord(chosenRecord: Person) {
        println("Name: ${chosenRecord.name}")
        println("Surname: ${chosenRecord.surname}")
        println("Birth date: ${chosenRecord.birthDate}")
        println("Gender: ${chosenRecord.gender}")
        println("Number: ${chosenRecord.phoneNumber}")
        println("Time created: ${chosenRecord.timeCreated}")
        println("Time last edit: ${chosenRecord.timeEdited}")
        println("")
        enterAction(chosenRecord)
    }

    fun enterAction(chosenRecord: Person) {
        print("\nEnter action (edit, delete, menu): ")
        val action = readln().toString()
        when (action) {
            "edit" -> editRecord(chosenRecord)
            "delete" -> removeRecord(chosenRecord)
            "menu" -> menu()
        }
    }

    fun editRecord(chosenRecord: Person) {
        print("Select a field (name, surname, birth, gender, number): ")
        val editAction = readln().toString()
        when (editAction) {
            "name" -> {
                print("Enter name: ")
                chosenRecord.name = readln().toString()
                println("Saved")
                displayRecord(chosenRecord)
            }

            "surname" -> {
                print("Enter surname: ")
                chosenRecord.surname = readln().toString()
                println("Saved")
                displayRecord(chosenRecord)
            }

            "birth" -> {
                print("Enter birth date: ")
                chosenRecord.birthDate = readln().toString()
                println("Saved")
                displayRecord(chosenRecord)
            }

            "gender" -> {
                print("Enter gender: ")
                chosenRecord.gender = readln().toString()
                println("Saved")
                displayRecord(chosenRecord)
            }

            "number" -> {
                print("Enter the number: ")
                var phoneNumber = readln().toString()
                if (isPhoneNumber.matches(phoneNumber) && phoneNumber != "+1 ()") {
                    phoneNumber = phoneNumber
                    println("Saved")
                } else {
                    println("Wrong number format!")
                    phoneNumber = "[no number]"
                }
                displayRecord(chosenRecord)
            }
        }
    }

    fun removeRecord(chosenRecord: Person) {
        val recordIndex = contactsList.indexOf(chosenRecord)
        contactsList.removeAt(recordIndex)
        println("The record removed!")
        menu()
    }

}

class Organization(phoneNumber: String, var organizationName: String) : Contacts(phoneNumber) {
    var address: String = ""

    fun displayRecord(chosenRecord: Organization) {
        println("Organization name: ${chosenRecord.organizationName}")
        println("Address: ${chosenRecord.address}")
        println("Number: ${chosenRecord.phoneNumber}")
        println("Time created: ${chosenRecord.timeCreated}")
        println("Time last edit: ${chosenRecord.timeEdited}")
        enterAction(chosenRecord)
    }

    fun enterAction(chosenRecord: Organization) {
        print("\nEnter action (edit, delete, menu): ")
        val action = readln().toString()
        when (action) {
            "edit" -> editRecord(chosenRecord)
            "delete" -> removeRecord(chosenRecord)
            "menu" -> menu()
        }
    }

    fun editRecord(chosenRecord: Organization) {
        print("Select a field (name, address, number): ")
        val editAction = readln().toString()
        when (editAction) {
            "name" -> {
                print("Enter name: ")
                chosenRecord.organizationName = readln().toString()
                println("Saved")
                displayRecord(chosenRecord)
            }

            "address" -> {
                print("Enter address: ")
                chosenRecord.address = readln().toString()
                println("Saved")
                displayRecord(chosenRecord)
            }

            "number" -> {
                print("Enter the number: ")
                var phoneNumber = readln().toString()
                if (isPhoneNumber.matches(phoneNumber) && phoneNumber != "+1 ()") {
                    phoneNumber = phoneNumber
                    println("Saved")
                } else {
                    println("Wrong number format!")
                    phoneNumber = "[no number]"
                }
                displayRecord(chosenRecord)
            }
        }
    }

    fun removeRecord(chosenRecord: Organization) {
        val recordIndex = contactsList.indexOf(chosenRecord)
        contactsList.removeAt(recordIndex)
        println("The record removed!")
        menu()
    }

}

// Creating a function add() that creates an object of a class Contacts and adds it to the list
fun add() {
    print("Enter the type (person, organization): ")
    val type = readln().toString()

    when (type) {
        "person" -> {

            print("Enter the name of the person: ")
            val name = readln().toString()

            print("Enter the surname of the person: ")
            val surname = readln().toString()

            print("Enter the birth date: ")
            var birthDate = readln().toString()
            if (birthDate.isEmpty()) {
                birthDate = "[no data]"
                println("Bad birth date!")
            }

            print("Enter the gender (M, F): ")
            var gender = readln().toString()
            if (gender.isEmpty()) {
                gender = "[no data]"
                println("Bad gender!")
            }

            print("Enter the number: ")
            var phoneNumber = readln().toString()
            if (isPhoneNumber.matches(phoneNumber) && phoneNumber != "+1 ()") {
                phoneNumber = phoneNumber
            } else {
                println("Wrong number format!")
                phoneNumber = "[no number]"
            }

            val contact = Person(phoneNumber)
            contact.name = name
            contact.surname = surname
            contact.birthDate = birthDate
            contact.gender = gender

            contactsList.add(contact)

            menu()
        }

        "organization" -> {

            print("Enter the organization name: ")
            val organizationName = readln().toString()

            print("Enter the address: ")
            val address = readln().toString()

            print("Enter the number: ")
            var phoneNumber = readln().toString()
            if (isPhoneNumber.matches(phoneNumber) && phoneNumber != "+1 ()") {
                phoneNumber = phoneNumber
            } else {
                println("Wrong number format!")
                phoneNumber = "[no number]"
            }

            val organization = Organization(phoneNumber, organizationName)
            organization.address = address

            contactsList.add(organization)

            menu()
        }

    }
}

// Creating a function list() that lists all the available contacts in the contactsList
fun list(justListing: Int = 0) {

    if (contactsList.isNotEmpty()) {
        var counter = 0

        for (record in contactsList) {
            counter++
            if (record is Person) {
                println("$counter. ${record.name} ${record.surname}")
            } else if (record is Organization) {
                println("$counter. ${record.organizationName}")
            }
        }

        if (justListing == 0) {

            print("\nEnter action ([number], back): ")
            val choice = readln().toString()
            if (choice == "back") {
                menu()
            } else {
                val choiceRecord = choice.toInt()
                val chosenRecord = contactsList[choiceRecord - 1]

                if (chosenRecord is Person) {
                    chosenRecord.displayRecord(chosenRecord)
                } else if (chosenRecord is Organization) {
                    chosenRecord.displayRecord(chosenRecord)
                }
            }
        }

    } else {
        println("No records to list!")
        menu()
    }

}

// Creating a function remove() that removes a definite contact from the contactsList
fun remove() {
    if (contactsList.isNotEmpty()) {
        list(1)
        print("Select a record: ")
        val isDigit = "\\d".toRegex()
        val chooseContact = readln().toString()
        if (chooseContact.matches(isDigit)) {
            if (chooseContact.toInt() <= contactsList.size && chooseContact.toInt() >= 1) {
                contactsList.removeAt(chooseContact.toInt() - 1)
                println("The record removed!")
                menu()
            } else {
                println("No records to remove!")
                menu()
            }
        } else {
            println("Please use only digits!")
            menu()
        }
    } else {
        println("No records to remove!")
        menu()
    }
}

// Creating a function edit() that can edit a specific contact
fun edit() {
    if (contactsList.isNotEmpty()) {
        list(1)
        print("Select a record:")
        val isDigit = "\\d".toRegex()
        val chosenRecord = readln().toString()
        if (chosenRecord.matches(isDigit)) {
            if (chosenRecord.toInt() in 1..contactsList.size) {
                val contact = contactsList[chosenRecord.toInt() - 1]

                if (contact is Person) {

                    print("Select a field (name, surname, birth, gender, number): ")
                    val chosenField = readln().toString()
                    when (chosenField) {
                        "name" -> {
                            print("Enter name: ")
                            contact.name = readln().toString()
                            println("The record updated!")
                            contact.timeEdit()
                            menu()
                        }

                        "surname" -> {
                            print("Enter surname: ")
                            contact.surname = readln().toString()
                            println("The record updated!")
                            contact.timeEdit()
                            menu()
                        }

                        "birth" -> {
                            print("Enter birth date: ")
                            contact.birthDate = readln().toString()
                            println("The record updated!")
                            contact.timeEdit()
                            menu()
                        }

                        "gender" -> {
                            print("Enter gender: ")
                            contact.gender = readln().toString()
                            println("The record updated!")
                            contact.timeEdit()
                            menu()
                        }

                        "number" -> {
                            print("Enter number: ")
                            val newNumber = readln().toString()
                            if (isPhoneNumber.matches(newNumber) && newNumber != "+1 ()") {
                                contact.phoneNumber = newNumber
                                println("The record updated!")
                                contact.timeEdit()
                                menu()
                            } else {
                                println("Wrong number format!")
                                contact.phoneNumber = "[no number]"
                                contact.timeEdit()
                                menu()
                            }
                        }
                        else -> menu()
                    }

                } else if (contact is Organization) {

                    print("Select a field (address, number): ")
                    val chosenField = readln().toString()
                    when (chosenField) {
                        "address" -> {
                            print("Enter address: ")
                            contact.address = readln().toString()
                            println("The record updated!")
                            contact.timeEdit()
                            menu()
                        }

                        "number" -> {
                            print("Enter number: ")
                            val newNumber = readln().toString()
                            if (isPhoneNumber.matches(newNumber) && newNumber != "+1 ()") {
                                contact.phoneNumber = newNumber
                                println("The record updated!")
                                contact.timeEdit()
                                menu()
                            } else {
                                println("Wrong number format!")
                                contact.phoneNumber = "[no number]"
                                contact.timeEdit()
                                menu()
                            }
                        }
                        else -> menu()
                    }

                }

            } else {
                println("No records to edit")
                menu()
            }
        } else {
            println("No records to edit")
            menu()
        }
    } else {
        println("No records to edit")
        menu()
    }
}

fun searchRecord() {
    var resultsCounter = 0
    val resultsMap: MutableMap<Int, Int> = mutableMapOf()
    print("Enter search query: ")
    val searchInput = readln().uppercase()
    val searchWord: Regex = searchInput.toRegex()
    for (record in contactsList) {
        if (record is Person) {
            val findAllResults = searchWord.find(record.name.uppercase() + record.surname.uppercase() +
                    record.birthDate + record.gender.uppercase() + record.phoneNumber + record.timeCreated + record.timeEdited)
            if (findAllResults != null) {
                ++resultsCounter
                resultsMap.put(resultsCounter, contactsList.indexOf(record))
            }
        } else if (record is Organization) {
            val findAllResults = searchWord.find(record.organizationName.uppercase() + record.address.uppercase() + record.phoneNumber +
                    record.timeCreated + record.timeEdited)
            if (findAllResults != null) {
                ++resultsCounter
                resultsMap.put(resultsCounter, contactsList.indexOf(record))
            }
        }
    }

    println("Found $resultsCounter results:")

    for (key in resultsMap.keys) {
        val valueInMap: Int? = resultsMap.get(key)
        val actualContact = contactsList[valueInMap!!]
        if (actualContact is Person) {
            println("${key}. ${actualContact.name} ${actualContact.surname}")
        } else if (actualContact is Organization) {
            println("${key}. ${actualContact.organizationName}")
        }
    }

    println("")
    print("Enter action([number], back, again): ")

    val choice = readln().toString()

    when (choice) {
        "back" -> menu()
        "again" -> searchRecord()
        else -> {
            val chosenRecord = contactsList[resultsMap.get(choice.toInt())!!]
            if (chosenRecord is Person) {
                chosenRecord.displayRecord(chosenRecord)
            } else if (chosenRecord is Organization) {
                chosenRecord.displayRecord(chosenRecord)
            }
        }
    }
    menu()
}

// Creating a function count() that counts the number of records in the contactsList
fun count() {
    println("The Phone Book has ${contactsList.size} records.")
    menu()
}

fun menu() {
    println("")
    print("Enter action (add, remove, edit, list, search, count, exit): ")
    val input = readln().toString()
    when (input) {
        "add" -> add()
        "remove" -> remove()
        "search" -> searchRecord()
        "edit" -> edit()
        "list" -> list()
        "search" -> searchRecord()
        "count" -> count()
        "exit" -> exitProcess(0)
    }
}

fun main() {

    menu()

}