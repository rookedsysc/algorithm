def user_input
  input = gets 
  arr = []
  for i in input.split(" ").to_a
    arr << i.to_i
  end
  arr
end

def solve
  arr = user_input
  works = 0
  tired = 0
  for i in 0...24 
    if tired + arr[0] > arr[3]
      tired -= arr[2]
      if tired < 0 
        tired = 0
      end
    else
      tired += arr[0]
      works += arr[1]
    end
  end
  puts works
end

solve