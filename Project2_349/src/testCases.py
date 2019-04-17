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
    print("Test input " + file)
    p = subprocess.Popen(['java', 'MatrixWork'], stdin=subprocess.PIPE, stdout=subprocess.PIPE, encoding='utf8')

    out, err = p.communicate(input=(file+'\n'))

    out = out[out.find('\n')+1:out.rfind('\n')] #remove extra lines

    print(out.replace(" ","") == numpy_solve(file).replace(" ",""))
    print()

def test_error(file):
    print("Test ERROR " + file)
    p = subprocess.Popen(['java', 'MatrixWork'], stdin=subprocess.PIPE, stdout=subprocess.PIPE, stderr=subprocess.PIPE, encoding='utf8')

    out, err = p.communicate(input=(file+'\n'))
    err = (err.split("\n")[0].split(" ")[4])
    print(err == ("java.lang.IllegalArgumentException"))
    print()

#breaks if newline??

test_input_match('test.txt')
test_input_match('testFlat.txt')
test_error('break.txt')

