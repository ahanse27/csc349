import os
import subprocess
import sys
import numpy as np
import re

def numpy_solve(file):
    a = []
    b = []

    with open(file, 'r') as myfile:
      data = myfile.read().replace('\n', ' ')

    #load first array
    index = 0
    size = []
    s=2
    while(s>0):
      if (data[index].isdigit()):
          s=s-1
          size.append(int(data[index]))
      index=index+1

    #print(size)
    s=size[0]*size[1]

    while(s>0):
      if (data[index].isdigit()):
        s=s-1
        a.append(int(data[index]))
      index=index+1

    a = np.asarray(a).reshape((size[0], size[1]))
    #print(a)

    # load second array
    size = []
    s=2
    while(s>0):
      if (data[index].isdigit()):
          s=s-1
          size.append(int(data[index]))
      index=index+1

    #print(size)
    s=size[0]*size[1]

    while(s>0):
      if (data[index].isdigit()):
        s=s-1
        b.append(int(data[index]))
      index=index+1

    b= np.asarray(b).reshape((size[0], size[1]))

    #solve with numpy
    ans = (np.matmul(a,b))

    ans = (np.array2string(ans, separator=' '))
    chars = "[]"
    for c in chars:
      ans = ans.replace(c, "")
    ans = ans.replace("\n ", "\n")
    return (ans)


def test_input_match(file):
    print("----------\nTest input DAC " + file)
    p = subprocess.Popen(['java', 'MatrixPrint'], stdin=subprocess.PIPE, stdout=subprocess.PIPE, encoding='utf8')

    out, err = p.communicate(input=(file+'\n'))

    out = out[out.find('\n')+1:out.rfind('\n')] #remove extra lines
    np_out =  numpy_solve(file)
    res = (out.replace(" ","") == numpy_solve(file).replace(" ",""))
    print(res)
    if (res == False):
       print(out)
       print()
       print(np_out)
    print()

    print("Test input Strassen's " + file)
    p = subprocess.Popen(['java', 'MatrixPrint2'], stdin=subprocess.PIPE, stdout=subprocess.PIPE, encoding='utf8')

    out, err = p.communicate(input=(file+'\n'))

    out = out[out.find('\n')+1:out.rfind('\n')] #remove extra lines
    np_out =  numpy_solve(file)
    res = (out.replace(" ","") == numpy_solve(file).replace(" ",""))
    print(res)
    if (res == False):
        print(out)
        print()
        print(np_out)
    print()

#def test_error(file):
#    print("Test ERROR " + file)
#    p = subprocess.Popen(['java', 'MatrixPrint'], stdin=subprocess.PIPE, stdout=subprocess.PIPE, stderr=subprocess.PIPE, encoding='utf8')

#    out, err = p.communicate(input=(file+'\n'))
#    out = (out.split("\n")[0].split(" ")[])
#    print(out == ("Invalid Matrices"))
#    print(out)

#breaks if newline??


test_input_match('test.txt')  #2x2
test_input_match('test1.txt') #4x4
test_input_match('test2.txt') #8x8
#test_error('test4.txt') #8x8


#test case doesnt work for sizes above 9

#test_error('break.txt')

