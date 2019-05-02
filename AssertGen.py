import os


def main(arg):
    ind=1
    runner=''
    asserts=open('Asserts/'+arg+'.txt').readlines()
    for lines in asserts:
        if 'assert' not in lines:
            runner+=lines[:-1]+'\n'
            print(lines[:-1])
        else:
            runner+='try {\n\t'+lines+'\tSystem.out.println(\"Passed '+str(ind)+'"); \n}\n'+'catch(Exception |AssertionError e ) {\n\tSystem.out.println(\"Failed '+str(ind)+'\");\n}'
            print('try {\n\t'+lines+'\tSystem.out.println(\"Passed '+str(ind)+'"); \n}\n'+'catch(Exception |AssertionError e ) {\n\tSystem.out.println(\"Failed '+str(ind)+'\");\n}')
            ind+=1
    if not os.path.isdir(os.path.join('Resources', arg)):
        os.makedirs(os.path.join('Resources', arg))
    with open(os.path.join('Resources',arg)+'/runner.java','w') as file:
        file.writelines(runner)
        file.close()

if __name__ == '__main__':
    HWID='hw5'
    main(HWID)
