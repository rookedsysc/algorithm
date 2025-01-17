P = gets.to_i
N = gets.to_i
$arr = []

def move_right(idx) 
  idx 
  for i in idx...100 
    $arr[i] += 1
  end
end

def move_left(idx) 
  idx -= 1
  for i in (0...idx)
    $arr[i] += 1
  end
end

for _ in 0...100 do
  $arr << 0
end

for i in 0...N do 
  temp = gets.split(" ")
  idx = temp[0].to_i
  word = temp[1].to_s

  if word == 'R' 
    move_right(idx)
  else 
    move_left(idx)
  end
end

map = {}
map[0] = 0
map[1] = 0
map[2] = 0

for i in 0...100 
  map[$arr[i] % 3] += 1
end

puts format('%.2f', P * (map[0] / 100.00))
puts format('%.2f', P * (map[1] / 100.00))
puts format('%.2f', P * (map[2] / 100.00))