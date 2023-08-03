# stock-market-info with springboot
![img.png](img.png)


● 해당 주식(stock)에 댓글(comment)추가
Post
http://localhost:8080/api/v1/comment

Body
{
"stockId" : n번 주식, (Long)
"memberId" : n번 멤버, (Long)
"content" : "댓글" (String)   
}

● 해당 주식의 댓글 또는 모든 댓글 조회 (답변까지)
Get
http://localhost:8080/api/v1/comment || http://localhost:8080/api/v1/comment/stockId

● 해당 댓글의 좋아요
Put
http://localhost:8080/api/v1/comment

param
commentId = 해당 댓글의 id (Long)
memberId = 해당 댓글을 단 멤버의 id (Long)
num = 좋아요 버튼기능 (int) 1 : 좋아요, 0 : 좋아요 취소


● 해당 댓글의 답변달기
`Post`
http://localhost:8080/api/v1/subComment

Body
{
"commentId" : n번 댓글, (Long)
"memberId" : n번 멤버, (Long)
"content" : "답변" (String)   
}

● 해당 답변의 좋아요
Put
http://localhost:8080/api/v1/subComment

param
subCommentId = 해당 답변의 id (Long)
memberId = 해당 답변을 단 멤버의 id (Long)
num = 좋아요 버튼기능 (int) 1 : 좋아요, 0 : 좋아요 취소


● 주식(Stock)의 적극매도, 매도, 매수, 적극매수 (추천)
Put
http://localhost:8080/api/v1/stock

param
stockId = 주식id (Long)
memberId = 멤버id (Long)
num = 기능 (int) 1 : 적극매수,
2 : 매수,
3 : 매도,
4 : 적극매도








