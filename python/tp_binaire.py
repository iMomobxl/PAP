def estMajuscule(c):
    assert ('A' <= c <= 'Z') or ('a' <= c <= 'z'); "ce n'est pas une lettre"
    return ( ord (c) & 32 ) == 0

if __name__ == "__main__":
    print('A est une majuscule:', estMajuscule('A'))
    print('a est une majuscule:', estMajuscule('a'))