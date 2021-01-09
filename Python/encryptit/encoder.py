import random as r

def keyGenerator(choosen):
    key = 1 + r.randint(1, choosen)  #random
    return key

class encrypter:
    def __init__(self, key = 0):
        self.alpha1 = "abcdefghijklmnopqrstuvwxyz#*&@$"     #len = 31
        self.alpha2 = "%wqertyuiop*asdf-ghjkl4zxcvb#nm"     #len = 31    %*#-4
        self.num1 = "0123456789.%-"       #len = 13
        self.num2 = "50@239^$7&681"       #len = 13
        self.key = keyGenerator(key)

    def __joiner(self, Str, letter_sp):
        Str += str(letter_sp)
        return Str

    def __rev(self, x):
      return x[::-1]

    def __encodeAlter(self):
        self.alpha1 = self.__rev(self.alpha1)

        self.t = self.alpha1[0]
        self.alpha1 = self.alpha1[1:]
        self.alpha1 += self.t

        self.alpha1 = self.__rev(self.alpha1)


    def encode(self, inp):
        inp = inp.lower()
        letter_sp = '0'

        key = str(self.key)
        letter_sp = key[0]
        for i in range(1, self.key+1):
            match = self.num1[i]
            if letter_sp == match:
                letter_sp = self.num2[i]
                break

        for i in range(self.key):
            self.__encodeAlter()

        temp = ""
        for Str in range(len(inp)):
            letter = inp[Str]
            if letter.isalpha() or letter=='#' or letter=='*' or letter=='&' or letter=='@' or letter=='$':
                for i in range(31):
                    match = self.alpha1[i]
                    if letter == match:
                        temp += str(self.alpha2[i])
                        self.__encodeAlter()
                        break

            elif letter.isnumeric() or letter=='.' or letter=='%' or letter=='-': # Encrypting Digits
                for i in range(13):
                    match = self.num1[i]
                    if letter == match:
                        temp += str(self.num2[i])
                        self.__encodeAlter()
                        break

            elif letter == '\n':
                temp += str('\n')

            else:
                temp += str(letter)


        return self.__joiner(temp, letter_sp)


# ends class

if __name__ == '__main__':
    thisEncrypter = encrypter()
    return thisEncrypter # thisEncrypter.encode(msg)

# ends main

