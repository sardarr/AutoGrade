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


Any question about the auto grader pipeline please contact sardar at gwu dot edu.

