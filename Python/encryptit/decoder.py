def keyRetreiver(msg, num1, num2):
    key = -1
    check = msg[len(msg)-1]
    
    for i in range(10):
        if check == num2[i]:
            check = num1[i]
            key = i
            break
    
    return key


class decrypter:
    def __init__(self):
        self.alpha1 = "abcdefghijklmnopqrstuvwxyz#*&@$"     #len = 31
        self.alpha2 = "%wqertyuiop*asdf-ghjkl4zxcvb#nm"     #len = 31    %*#-4
        self.num1 = "0123456789.%-"       #len = 13
        self.num2 = "50@239^$7&681"       #len = 13
        self.key = None

    def __decodeAlter(self):
        self.t = self.alpha2[0]
        self.alpha2 = self.alpha2[1:]
        self.alpha2 += self.t

    def decode(self, inp):
        inp = inp.lower()

        initial = keyRetreiver(inp, self.num1, self.num2)

        for i in range(initial):
            self.__decodeAlter()

        temp = ""
        for Str in range(len(inp)):
            real = inp[Str]
            if real.isalpha() or real=='%' or real=='*' or real=='#' or real=='-' or real=='4':
                for i in range(31):
                    match = self.alpha2[i]
                    if real == match:
                        temp += str(self.alpha1[i])
                        self.__decodeAlter()
                        break

            elif (real.isnumeric() and real!='4') or real=='@' or real=='$' or real=='&' or real=='^':
                for i in range(13):
                    match = self.num2[i]
                    if real == match:
                        temp += str(self.num1[i])
                        self.__decodeAlter()
                        break

            elif real == '\n':
                temp += str('\n')

            else:
                temp += str(real)

        temp = temp[0:len(inp)-1]
        return temp


# class ends here

if __name__ == '__main__':
    thisDecoder = decrypter()
    return thisDecoder # thisDecoder.decode(msg)

# ends main





