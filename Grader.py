import os
import subprocess
import shutil

def Clean(student,arg):
    """
    :param student: Get the student homework path
    :param arg: the requiremnet and hw ID
    :return: Deletes the .class files and runner if it is already in the direcotry
    """
    test = os.listdir(student)
    for item in test:
        if item.endswith(".class") or item=='runner.java':
            os.remove(os.path.join(student, item))
        elif item.endswith(".java") and item not in arg['req'].keys():
            os.remove(os.path.join(student, item))

def CopyRequirments(student,arg):
    """
    :param student: Student homework path
    :param arg: the homework main args
    :return: coppies the neccesary dir if they don exist in the target path
    """
    res_path=os.path.join('Resources',arg['hwID'])
    src_files = os.listdir(res_path)
    student_files=os.listdir(student)
    for file_name in src_files:
        full_file_name = os.path.join(res_path, file_name)
        if (os.path.isfile(full_file_name)) and file_name not in student_files:
            shutil.copy(full_file_name, student)

def Compiler(student):
    test = os.listdir(student)
    cmd = 'javac '+student+"/*.java"
    try:
        os.system(cmd)
        return True
    except:
        return False


def Runner(stundet):
    try:
        res = os.popen('java -ea -cp ' + stundet + " runner").read()
        return res
    except:
        return 'error'

def resParser(result):
    splited_res=result.split('\n')
    passed=0
    failed=0
    log={}
    for items in splited_res:
        if 'Passed' in items:
            passed+=1
        else:
            failed+=1
    log={'total':len(splited_res),'passed':passed,'failed':failed,'Grade':passed/len(splited_res)}
    return log



def main():
    print("your grade")


if __name__ == '__main__':
    grades={}
    conf={'hwID':'hw3_debug','req':{'OneDimensional2048.java':'OneDimensional.java',}}
    homework_root='Homework/' + conf['hwID']
    list_of_students=os.listdir(homework_root)
    for student_dir in list_of_students:
        student_dir_full_path=os.path.join(homework_root,student_dir)
        Clean(student_dir_full_path,conf)
        CopyRequirments(student_dir_full_path,conf)
        if(Compiler(student_dir_full_path)):
            res=Runner(student_dir_full_path)
            if res!='error':
                grades[student_dir]=resParser(res)
            else:
                grades[student_dir] ='Running time error'
        else:
            grades[student_dir]='compile Error'

    print(grades)