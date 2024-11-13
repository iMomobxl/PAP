# math pour nbChiffresV3
import math

# nombre de chiffres : Version 1
def nbChiffresV1(n):
    assert n >= 0; 'n doit etre >= 0'
    return len(str(n))

# nombre de chiffres : Version 2
def nbChiffresV2(n):
    assert n >= 0; 'n doit etre >= 0'
    res = 1
    while ((n // 10) != 0):
        res += 1
        n = n // 10
    return res

# nombre de chiffres : Version 3 
def nbChiffresV3(n):
    assert n >= 0; 'n doit etre >= 0'
    if n == 0 or n == 1:
        return 1
    if n % 10 == 0:
        return math.ceil(math.log10(n)) + 1
    return math.ceil(math.log10(n))

# inversion du nombre : Version 1
def inverseNbrV1(n):
    assert n >= 0; 'n doit etre >= 0'
    res = 0
    while n > 0:
        res *= 10
        res += n % 10
        n = n // 10
    return res

# inversion du nombre : Version 2
def inverseNbrV2(n):
    assert n >= 0; 'n doit etre >= 0'
    return int(str(n)[::-1])

# conversion de température V1
def convertTemp(t:float, unitI:str, unitD:str) -> float:
    assert (unitD == 'K' or unitD == 'C' or unitD == 'F') and ((unitI == 'K' and t >= 0) or unitI == 'C' or unitI == 'F'); 'unitD doit etre K, C ou F'
    if unitI == unitD:
        return t
    if unitI == 'C':
        if unitD == 'F':
            return (t * 9 / 5) + 32
        return t + 273.15
    if unitI == 'F':
        if unitD == 'C':
            return round((t - 32) * (5 / 9), 2)
        return (t - 32) * 5 / 9 + 273.15
    if unitD == 'C':
        return t - 273.15
    return (t - 273.15) * 9 / 5 + 32

# conversion de température V2
def convertTempV2(t:float, unitI:str, unitD:str):
    assert (unitD == 'K' or unitD == 'C' or unitD == 'F') and ((unitI == 'K' and t >= 0) or unitI == 'C' or unitI == 'F'); 'unitD doit etre K, C ou F'
    
    if unitI == unitD:
        return t
    
    cf = lambda x: (x * 18) / 10 + 32.0
    fc = lambda x: (x - 32.0) * 10 / 18.0
    ck = lambda x: (x + 273.15)
    kc = lambda x: (x - 273.15)
    
    if unitI == 'K':
        dc = kc(t)
    elif unitI == 'F':
        dc = fc(t)
    else:
        dc = t
        
    if unitD == 'K':
        res = ck(dc)
    elif unitD == 'F':
        res = cf(dc)
    else:
        res = dc
    return res

if __name__ == '__main__':
    '''
    print(nbChiffresV1(2631)) 
    print(nbChiffresV1(0))
    print(nbChiffresV2(2631))
    print(nbChiffresV2(0))
    print(nbChiffresV3(2631))
    print(nbChiffresV3(0))
    print(inverseNbrV1(123456789))
    print(inverseNbrV2(123456789))
    '''
    print(convertTemp(38, 'C', 'F'))
    print(convertTemp(100.4, 'F', 'C'))
    print(convertTemp(100.4, 'F', 'K'))
    print(convertTemp(311.15, 'K', 'C'))
    print(convertTemp(38, 'C', 'C'))
    
    print(convertTempV2(38, 'C', 'F'))
    print(convertTempV2(100.4, 'F', 'C'))
    print(convertTempV2(100.4, 'F', 'K'))
    print(convertTempV2(311.15, 'K', 'C'))
    print(convertTempV2(38, 'C', 'C'))
    