import os
import subprocess
import shutil


def assert_mapper(conf):
    """
    :param conf: the configuration
    :return: Dictionary contains the assert index and the assetion line from the assertion file
    """
    ind=1
    asser_table={}
    asserts=open('Asserts/'+conf['hwID']+'.txt').readlines()
    for lines in asserts:
        if 'assert' in lines:
            asser_table[str(ind)]=lines
            ind+=1
    return asser_table


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
        res=subprocess.call(cmd, shell=True)
        return res
    except:
        return res


def Runner(stundet):
    try:
        res = os.popen('java -ea -cp ' + stundet + " runner").read()
        return res
    except:
        return 'error'

def resParser(result,assert_tbl):
    splited_res=[msg for msg in result.split('\n') if len(msg)>4]
    passed=0
    failed=0
    fail_log=""
    for items in splited_res:
        if 'Passed' in items:
            passed+=1
        else:
            failed+=1
            fail_log+=assert_tbl[items.split(" ")[1]][:-1]+"\t"
    failed=len(assert_tbl)-passed
    log={'total':len(assert_tbl),'passed':passed,'failed':failed,'Grade':10*(passed/len(assert_tbl)),'failed_log':fail_log}
    return log



def main():
    print("your grade")


if __name__ == '__main__':
    grades={}
    # conf={'hwID':'hw3_debug','req':{'OneDimensional2048.java':'OneDimensional.java',}}
    # conf={'hwID':'hw4_debug','req':{'OneDimensional2048.java':'OneDimensional.java','TwoDimensional2048.java':'TwoDimensional.java'}}
    conf={'hwID':'hw5r3','req':{'OneDimensional2048.java':'OneDimensional.java','TwoDimensional2048.java':'TwoDimensional.java',\
                                'TwoThousandFourtyEight.java':'TwoThousandFourtyEightInt.java','Ai2048.java':''}}

    homework_root='Homework/' + conf['hwID']
    list_of_students=os.listdir(homework_root)
    results=open(os.path.join('Results',conf['hwID']),'w')
    assert_tbl=assert_mapper(conf)

    for student_dir in list_of_students:
        try:
            student_dir_full_path=os.path.join(homework_root,student_dir)
            Clean(student_dir_full_path,conf)
            CopyRequirments(student_dir_full_path,conf)
            if(Compiler(student_dir_full_path)==0):
                res=Runner(student_dir_full_path)
                if res!='error':
                    grades[student_dir]=resParser(res,assert_tbl)
                else:
                    grades[student_dir] ='Running time error'
            else:
                grades[student_dir]='compile Error'

            results.write(student_dir+' results '+str(grades[student_dir])+'\n')
        except:
            print(student_dir)

results.close()