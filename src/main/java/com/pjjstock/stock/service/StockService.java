package com.pjjstock.stock.service;

import com.pjjstock.member.domain.entity.Member;
import com.pjjstock.member.repository.MemberRepository;
import com.pjjstock.stock.domain.entity.Clicked;
import com.pjjstock.stock.domain.entity.Stock;
import com.pjjstock.stock.repository.ClickedRepository;
import com.pjjstock.stock.repository.StockRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class StockService {
    private final StockRepository stockRepository;
    private final MemberRepository memberRepository;
    private final ClickedRepository clickedRepository;

    public void clicked(Long stockId, Long memberId, int num) {
//        findById 를 통해 해당 stock(findStock)를 변환시켜야 하는거.
//        영속성 컨텍스트 : 쉽게 생각하면 캐시 sql쿼리를 모아놨다가 트랜잭션이 끝날시점에 한번에 DB에 보낸다. 그리고 처음 영속성컨텍스트와
//        마지막 커밋시점에서 다른점이 발생하면 자동적으로 update를 해준다.
        Stock findStock = stockRepository.findById(stockId)
                .orElseThrow(NoSuchElementException::new);
        Member findMember = memberRepository.findById(memberId)
                .orElseThrow(NoSuchElementException::new);

        Optional<Clicked> checkId = clickedRepository.findByStockIdAndMemberId(findStock.getId(), findMember.getId());

        Optional<Clicked> byNum = clickedRepository.findByNum(num);

        if (checkId.isEmpty()){
            Clicked newClicked = Clicked.builder().stock(findStock).member(findMember).num(num).build();
            clickedRepository.save(newClicked);

            switch (num) {
                case 1:
                    System.out.println("1번이면 적극매수");
                    findStock.increaseStrongBuy();
                    break;
                case 2:
                    System.out.println("2번이면 매수");
                    findStock.increaseBuy();
                    break;
                case 3:
                    System.out.println("3번이면 매도");
                    findStock.increaseSell();
                    break;
                case 4:
                    System.out.println("4번이면 적극매도");
                    findStock.increaseStrongSell();
                    break;
                default:
                    System.out.println("해당 번호에 대한 동작이 정의되지 않았습니다.");
                    return;
            }
        }else {
            clickedRepository.delete(byNum.get());
            switch (num) {

                case 1:
                    System.out.println("적극매수를 취소하였습니다.");
                    findStock.diminishStrongBuy();
                    break;
                case 2:
                    System.out.println("매수를 취소하였습니다.");
                    findStock.diminishBuy();
                    break;
                case 3:
                    System.out.println("매도를 취소하였습니다.");
                    findStock.diminishSell();
                    break;
                case 4:
                    System.out.println("적극매도를 취소하였습니다.");
                    findStock.diminishStrongSell();
                    break;
                default:
                    System.out.println("해당 번호에 대한 동작이 정의되지 않았습니다.");
                    return;
            }
        }
    }

}