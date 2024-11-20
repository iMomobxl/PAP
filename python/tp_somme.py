def sommeN_V1(n:int)->int:
    '''Calcule la somme des nombres de 1 à n
        avec une boucle for'''
    assert n>=0;'n doit être >=0'
    s = 0
    for i in range(1,n+1):
        s = s + i
    return s

def sommeN_V2(n:int)->int:
    '''Calcule la somme avec une formule'''
    assert n>=0;'n doit être >=0'
    return (n*(n+1))/2

def sommeN_V3(n:int)->int:
    '''Calcule la somme avec une formule bis'''
    assert n>=0;'n doit être >=0'
    if n>>2==0: return n/2 * (n+1)
    return (n+1)/2 * n

if __name__ == '__main__':
    print(sommeN_V2(2**31-1))
    print(sommeN_V1(2**31-1))
    