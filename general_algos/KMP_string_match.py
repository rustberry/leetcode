# KMP
def par_val (target):
    
    l = [0,0,0,0,1,2,0]
    d = {index: val for index, val in enumerate(l)}
    
    return d
    

def main(str, target):
    i, offset, length = 0, 0, len(str)
    len_tar = len(target)
    counter = 0
    parval_table = par_val(target)
    matched = False
    
    while i < length:
        try:
            while str[i] == target[counter]:
                i += 1
                counter += 1
                matched = True
        except IndexError:
            print("the index is", i, counter)
        
        if matched:
            i -= 1
            counter -= 1
            matched = False
        
        if  counter + 1 == len_tar and target[counter] == target[len_tar - 1]:
            return i - counter
            
        offset = counter - parval_table[counter]
        counter = counter - offset
        
        i += 1
    
    return False
    

if __name__ == '__main__':
    str = 'abcdab abcdabcdabde'
    target = 'abcdabd'
    
    res = main(str, target)
    
    if res is False:
        print("Failed")
    else:
        print("The index found is", res)
        print(str)
        print("str matched: (%s)" % str[res:])