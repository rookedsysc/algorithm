def sum_by_index(value_list:list, index_list:list) :
  ans = 0
  for i in index_list :
    ans += value_list[i]
  
  return ans

def solution(bridge_length, weight, truck_weights):
  ans = 0
  bridge = []
  in_bridge_cnt_hash = {}
  last_index = -1
  # 마지막 인덱스가 truck_wights의 마지막 인덱스보다 작거나
  # in bridge list가 0보다 크다면(다리 위에 아직 차들이 있음) 반복 수행
  while last_index < len(truck_weights) - 1 or len(bridge) > 0 :
    # 다리 위에 있는 차들에 대해서 카운트 감소 수행
    for b in bridge : 
      cur_cnt = in_bridge_cnt_hash[b] - 1
      in_bridge_cnt_hash[b] = cur_cnt
    
    # 다리 위에 있는 차들 중에서 카운트가 0이 된 차들에 대해서 pop() 수행
    while len(bridge) > 0 and in_bridge_cnt_hash[bridge[0]] < 1 :
      bridge.pop(0)
      
    ans += 1
    total_bidge_weight = sum_by_index(truck_weights, bridge)
    if last_index + 1 < len(truck_weights) :
      next_val = truck_weights[last_index + 1]
      if total_bidge_weight + next_val <= weight :
        last_index += 1
        in_bridge_cnt_hash[last_index] = bridge_length
        bridge.append(last_index)
  
  return ans 