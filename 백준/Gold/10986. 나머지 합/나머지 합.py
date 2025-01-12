def count_subarrays(N, M, A):
    # 누적합의 나머지를 저장할 배열
    remainder_count = [0] * M
    prefix_sum = 0
    count = 0

    for a in A:
        # 누적 합 계산
        prefix_sum += a
        # 나머지 계산 (음수 방지)
        remainder = prefix_sum % M

        # 누적합이 0으로 나누어 떨어지는 경우 추가
        if remainder == 0:
            count += 1

        # 이전 나머지가 같은 누적합 쌍의 개수 추가
        count += remainder_count[remainder]

        # 현재 나머지의 개수 증가
        remainder_count[remainder] += 1

    return count

# 입력 처리
N, M = map(int, input().split())
A = list(map(int, input().split()))

# 결과 출력
print(count_subarrays(N, M, A))