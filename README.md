# CircularQueue
Java implementation of a circular queue

Usage: java CircularQueue `<name of file with commands>`

All commands must be provided as a space-separated list in a text file. An example file, circTest.txt, has been included in the repository.

Commands:
* Add a node with value of `key` onto the tail of the queue - use "key.in"  
* Remove a node from the head of the queue - use "del"

The first entry in the command file MUST be an integer that specifies the size of the queue.

Entries that exceed the size of the queue will be ignored.

Example: `5 1.in 2.in 3.in 4.in 5.in del 6.in 7.in`

The output will be `2 3 4 5 6`
  
Only integers are allowed as keys. 

The updated queue will be output to the command line after each command. 

