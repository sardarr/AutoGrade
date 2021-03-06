# AutoGrade

This pipeline is designed to ease the grading experience for the course CS1111.
Following steps have to be taken before running the Grader. 

HOW IT WORKS?

Grader.py needs some requirements for each homework which includes interface files and in some cases the other resources exp. '.XML' files which might be required for certain homework. For each homework, the requited files should be located in /Resources directory. For example. if codeInterface.java is required for homework2  it should be insider 'Resources/HW2/' directory.
Besides all the required files for that homework, there is another file needed to run the main method which contains all the assertions. This file can be created using the 'AssetGem.py.' In order to run this code, the main java code should be copied as a  '.txt' file inside the '/Asserts' directory.
For example, 'Asserts/hw2.txt' in this directory contains the content of the java file which is provided for students (Renaming the file is optional as we changed them all in "hw" scheme to make it more consistent).
After putting the main code inside the /Asserts directory, run the AssertGen.py by setting the "HWID" to point to a right file exp. "hw2". AssertGen.py will create a method called 'runner.java' inside the
'Resources/hw2/runner.java'.
For the final step, run the Grader.py by setting the configurations pointing to the right Homework. "conf" includes two main parameters, first, 'hwID' and the second one is 'req.'
'hwID' is to point to the right resource and homework directory and 'req' is to set right relations between the codes and interfaces. For example, if 'condInt.java' is the required interface file for 'code.java' the right format in conf is  conf={'hwID':'hw2','req':{'code.java':'codeInt.java','Ai2048.java':''}}.
If there is another file which has no interface but needed to be submitted by the students has to be put inside conf like
'Ai2048.java' . 
After running the grader, the results will be copied in /Results directory with the same name as 'hwID'.

'/Homework' directory contains the subdirectory for each homework with the same name as 'hwID' which was used in the Grader conf.
exp. '/Homework/hw2/' should contain one directory for each students including all the submitted files by the students.

Summary of steps:

A)Creating the runner.java

    1)Copy the homework hw#.java (Which contains all the assertions) as 'hw#.txt' in Asserts
    2)Change the HWID in AssetGen.py to appropriate homework ID which exist in /Asserts (Step 1)
    3)Python AssrtGen.py
B)Requirements
    
    1) Copying all the requirements insider /Resources/hw#/ this included only the interface files and other resources 
    2) THe runner.java which was generated from the previous step should be inside this directory as well. 
C)Running the Grader
    
    1)Setting the conf inside the Grader.py to the right hw# and setting the right key/value for the 'req' as  req:{'main.java':'mainInterface'}
    2)Setting the cond for the required files with no interface req:{'ai2048':''}
    3)python Grader.py

Any question about the auto grader pipeline please contact _sardar at gwu dot edu._

