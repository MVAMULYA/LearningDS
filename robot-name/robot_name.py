import random
class Robot:
    def __init__(self):
        self.name = '' + chr(random.randint(65,90)) + chr(random.randint(65,90)) + str(random.randint(0,9)) + str(random.randint(0,9)) +str(random.randint(0,9))
        
    def reset(self):
        random.seed('no duplicates')
        self.__init__()

    def print_name(self):
        return(self.name)



