def solution(stones, k) :
  answer = 0
  left, right = 1, max(stones)
  while left <= right :
    # ct에 들어가는 값은 stones와 mid의 값을 뺏을 때
    # 건너뛰어야 하는 돌의 개수를 카운팅하는 변수이다.
    # 즉 4 1 2 4 인 상태에서
    # mid의 값이 3이 된다면
    # ct가 2를 지날 때 2까지 올라간다.
    # 이 때, k가 1이라면 ct < k 조건에 충족하지 못하게되고
    # right 값을 조정하게 되는 것이다.
    ct = 0
    mid = (left + right) // 2
    for stone in stones :
      if (stone - mid) <= 0 :
        ct += 1
      else :
        ct = 0
      if ct >= k :
        break
    if ct < k :
      left = mid + 1
    else :
      answer = mid
      right = mid - 1

  return answer