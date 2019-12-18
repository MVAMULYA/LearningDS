def convert(number):
    raindrop_string = ''
    if(number % 3 == 0):
        raindrop_string += 'Pling'
    if(number % 5 == 0):
        raindrop_string += 'Plang'
    if(number % 7 == 0):
        raindrop_string += 'Plong'
    if(number % 3 != 0 and number % 5 != 0 and number % 7 != 0):
        raindrop_string += str(number)
    return(raindrop_string)
