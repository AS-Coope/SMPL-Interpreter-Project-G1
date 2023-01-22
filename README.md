# SMPL-Interpreter-Project-G1
COMP 3652 - Final Project to complete an interpreter for the language SMPL
Lecturer: Prof. Daniel Coore

Final Date for Checkoff: January 4, 2022 

Notes:
\<l> means that the argument l is mandatory.
[p] means that the argument p is mandatory.

Functionality (SMPL currently supports):
- Signed Integers (Binary, Hexadecimal, Decimal). Binary Numbers are prefixed by #b and Hexadecimal Numbers are prefixed by #x.
- Strings are interpreted (escape characters are not interpreted properly).
- Characters are currently not interpreted.
- Pairs. Format: pair(<e1>, <e2>), where e1 and e2 are objects.
- Car, returns the first object in a pair. Format: car(\<p>), where p is a pair.
- Cdr, returns the second object in a pair. Format: cdr(<p>), where p is a pair.
- IsPair, returns true if the object is a pair. Format: pair?(<p>), where p is a pair.
- List, returns a newly allocated list (sequence of pairs terminating in nil) containing the values of the expression e1 through en. Format: list([<e1>, ..., <en>]).


Objectives:
1. Interpreting statements and expressions
2. Accounting for operator precedence and interpreting the various operators SMPL offers
3. Interpreting pairs and their associated operations (first obj of pair, second obj of pair, is of type pair)
4. Interpreting lists and the associated operations   
...more to be added later

Extensions (Optional):
1. Tail Recursion
2. Variable Arity Procedures
3. Default Parameters (referencing Python syntax)
4. Vector comprehension
5. Multiple valued (tuple) expressions and assignment
6. Lazy parameter passing
7. Object-oriented support
8. Call by reference parameter passing
9. Identifiers that permit arithmetic operators within them
10. Redefinable built-in procedures
11. Iteration forms

... and any additional ideas that pop up

