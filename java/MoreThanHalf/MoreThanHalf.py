def partition(li, start, end):
    value = li[start]
    while start < end:
        while li[end] >= value and start < end:
            end -= 1
        li[start] = li[end]
        while li[start] <= value and start < end:
            start += 1
        li[end] = li[start]
    li[start] = value
    return start


def sort(li, start, end):
    if start >= end:
        return
    middle = partition(li, start, end)
    sort(li, start, middle - 1)
    sort(li, middle + 1, end)


def verify(li, num):
    i = 0
    for value in li:
        if value == num:
            i += 1
    if i > len(li)/2:
        return True
    else:
        return False


def MoreThanHalf(li):
    middle = len(li) // 2
    start = 0
    end = len(li) - 1
    index = partition(li, start, end)
    while index != middle:
        if index > middle:
            end = index - 1
            index = partition(li, start, end)
        else:
            start = index + 1
            index = partition(li, start, end)
    num = li[index]
    if verify(li, num):
        return num
    else:
        return 0


print(MoreThanHalf([1, 2, 3, 2, 2, 2, 5, 4, 2]))
