def calculDecision(note : float)->str:
    ''' calcule la décision sur base de la note
        note sera un nombre entier ou float
    '''
    assert 0<=note<=100 , "La note doit être entre 0 et 100"
    if note<30:
        res = "Refus"
    elif note<50:
        res = "Ajourné"
    else:
        res= "Réussite"
    return res

if __name__ == "__main__":
    car = 'o'
    while car.lower() == 'o':
        #Input
        n = float(input("Entrez une note: "))
        while n<0 or n>100:
            print('Attention le nombre doit être entre 0 et 100')
            n = float(input("Entrez une note: "))
        
        #Traitement
        r = calculDecision(n)
        #Output
        print(f"La note de {n} donne une décision de {r}")
        
        #Continue?
        car = input("Voulez-vous continuer (o/n)")
    print('FIN')
