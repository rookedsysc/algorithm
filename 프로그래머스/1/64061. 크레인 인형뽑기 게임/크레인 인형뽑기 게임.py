def solution(board, moves):
    answer = 0
    R, N = len(board), len(board[0])
    basket = []
    top = 0
    for m in moves :
        r, c = R - 1, m - 1
        for i in range(R) :
            if board[i][c] != 0 :
                r = i
                break
        if top == board[r][c] :
            basket.pop()
            answer += 2
            if len(basket) > 0 :
                top = basket[-1]
            else :
                top = None
        elif board[r][c] == 0 :
            continue
        else :
            top = board[r][c]
            basket.append(board[r][c])
            
        board[r][c] = 0
        
    return answer