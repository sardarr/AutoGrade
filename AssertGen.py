import os


def main(arg):
    ind=1
    asserts=open('Asserts/'+arg+'.txt').readlines()
    for lines in asserts:
        if 'assert' not in lines:
            print(lines[:-1])
        else:
            print('try {\n\t'+lines+'\tSystem.out.println(\"Passed '+str(ind)+'"); \n}\n'+'catch(Exception |AssertionError e ) {\n\tSystem.out.println(\"Failed '+str(ind)+'\");\n}')
            ind+=1



if __name__ == '__main__':
    HWID='hw3'
    main(HWID)

#     try {
