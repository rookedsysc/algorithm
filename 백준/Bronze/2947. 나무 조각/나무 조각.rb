def puts_arr_to_str(arr)
  string = ""
  for e in arr
    string += e.to_s.chomp + " "
  end
  puts string
end

def bubble_sort(arr)
  len = arr.length
  for i in 0...len
    swap = false
    last = len - i - 1
    for j in 0...last
      if (arr[j] > arr[j + 1])
        temp = arr[j]
        arr[j] = arr[j + 1]
        arr[j + 1] = temp
        swap = true
        puts_arr_to_str(arr)
      end
    end
    if !swap then
      break
    end
  end
end

def input
  str = gets
  arr = str.split(" ")
  arr
end

def to_int_arr(arr)
  temp = []
  for e in arr
    temp << e.to_i
  end
  temp
end

def solve
  arr = input
  arr = to_int_arr(arr)
  bubble_sort(arr)
end

solve

