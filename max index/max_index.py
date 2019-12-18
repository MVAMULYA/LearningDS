array_length = int(input())
if( 1 <= array_length <= 10**5):
    array_list = list(map(int,input().split()))
    array_dict = dict()
    for i in range(len(array_list)):
        l1 = array_list[i:]
        l2 = []
        sum_l1 = 0
        j=0
        k=1
        while ( k+j <= len(l1)):
            l2.append(l1[j:k+j])
            sum_l1 += sum(l1[j:k+j])            
            j = k+j
            k +=1
        array_dict[i] = sum_l1
    max_value = max(array_dict.values())
    print(max_value)