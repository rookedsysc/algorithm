def set_same_length(param1, param2) 
  while true
    if param1.length > param2.length
      param2.unshift(0)
    elsif param2.length > param1.length
      param1.unshift(0)
    else
      break
    end
  end
  arr = [param1, param2]
end

def user_input
  str = gets.split(" ")
  param1 = str[0].split("").map do |i|
    i.to_i
  end.to_a
  param2 = str[1].split("").map do |i|
    i.to_i
  end.to_a
  arr = set_same_length(param1, param2)
end

def solve
  arr = user_input
  result = ""
  for i in 0...arr[0].length
    result += (arr[0][i] + arr[1][i]).to_s
  end
  puts result
end

solve