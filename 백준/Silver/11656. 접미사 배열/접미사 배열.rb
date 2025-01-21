def generate_suffixes(str)
  (0...str.length).map { |i| str[i..-1] }
end

def sort_suffixes(suffixes)
  suffixes.sort
end

def print_suffixes(sorted_suffixes)
  sorted_suffixes.each { |suffix| puts suffix }
end

def solve
  input_string = gets.chomp
  
  suffixes = generate_suffixes(input_string)
  
  sorted_suffixes = sort_suffixes(suffixes)
  
  print_suffixes(sorted_suffixes)
end

solve