from collections import Counter
def is_pangram(sentence):
    sentence = sentence.replace(' ', '').lower()
    count = Counter(sentence)
    key_count = 0
    for key in count:        
        if(97 <= ord(key) <= 122):
            key_count +=1    
    return(key_count == 26)
