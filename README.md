# SMPL-Interpreter-Project-G1
COMP 3652 - Final Project to complete an interpreter for the language SMPL.

## Project Overview + Inspiration
With foundational code developed and implemented by Professor D. Coore, the aim was (for us) to create an interpreter for the language SMPL based on its specification (at the time it was a group project). Despite the course coming to an end, this project was very interesting and as such, diving deeper into designing and implementing more functionality for the language is a burning desire. 

It is better to have objectives to guide in improving the language's capabilities than just arbitrarily implement various functionalities. As such, the final objective of this language is to build a simple game engine. This is pretty long term and will be more defined as the days progess but to have milestones for meeting that target, there will be other objectives. One such objective would be a simple physics engine, which would end up being a part of the game engine. Of course, given that is a pretty big milestone too, so other objectives will be created.

As I am currently learning to develop a game engine using C++ and Object Oriented Programming (with the ECS architectural pattern being used), I'm sure that will help me in understanding how to approach such a heavy task in SMPL. Given Object Oriented Programming will be used, making SMPL Object Oriented, which was an optional extension Professor Coore detailed in the specification, will go a long way.  

SMPL is built on top of Java.

Inspiration for building a game engine (and physics engine) came after watching this video: [Simulating an Entire Car Engine](https://www.youtube.com/watch?v=RKT-sKtR970)

## Objectives
- [ ] Create Game Engine  
- - [ ] Create Physics Engine    
- - [ ] Create Renderer  
- - [ ] Create Audio Engine   

- [ ] Create Physics Engine  

- [ ] Complete Specification Document Objects  
- - [ ] Functions (proc)  
- - [ ] Switch Statements  
- - [ ] Conditional Statements  
- - [ ] File Reading  
- - [ ] Object Oriented Programming  


*****More objectives to be added in the future

## How to use

The following are required to run this project:
- [Java](https://www.oracle.com/java/) - (SDK installed and added to path [Windows])  
- [Cup](https://github.com/duhai-alshukaili/CUP) - (Used for parsing; Add to path)  
- [JFlex](https://jflex.de/download.html) - (Used for regular expression [syntax]; Add to path) 
  
Instructions on adding each to path will be added over the coming days (However, the method used to add Java to path is similar for Cup and JFlex)...
  
### Windows

First, clone the project to your local machine.  
1. Navigate to the directory that has all the java files via the command prompt  
OR 
Navigate to that directory and click in the address bar  
![Windows File Explorer Address Bar](https://user-images.githubusercontent.com/94488901/227793032-650bb60c-9d66-4fe7-8b6b-b661ed647ee1.png)
Then type cmd and press the Enter key  

2. Enter the following command:  
```jflex Lexer.jflex```

3. Enter the following command:
```cup -parser ArithParser Parser.cup```

4. Enter the following command (compiles the Java files):  
```javac -classpath ".;<the path of your java-cup-11b.jar file>;lib3652.jar" *.java```  
**NOTE: the classpath separator on Windows is `;`**  
In the above code line, substitute the actual path to your java cup jar file for
> \<the path of your java-cup-11b.jar file>
>  
For example:  
![Example Java Cup Path](https://user-images.githubusercontent.com/94488901/227794099-36b84da5-a5e3-4059-b963-644db292878c.png)  
5. Enter the following command:
``` java -cp ".;<path to your java-cup-11b.jar file>;lib3652.jar" Main -w ArithInterpreter - ```  
After which you will be prompted to enter code following SMPL's syntax.  

### Testing SMPL
Try this:  
```x:=2;```  

The press the Enter key.  
Then type  
```.```  

Then press the Enter key again.  
The following should be returned:  
```Result: 2```
