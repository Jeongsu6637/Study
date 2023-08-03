package com.pjjstock.stock.domain.entity;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.validator.constraints.Length;
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Getter
@Table(name = "stocks_info", indexes = @Index(name = "idx_base_date", columnList = "base_date"))
public class StockInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "stock_code", nullable = false, unique = true)
    @Length(max = 7)
    private String stockCode;
    @Column(name = "base_date", nullable = false)
    @Length(max = 10)
    private String baseDate;
    @Column(name = "closing_price", nullable = false)
    private Integer closingPrice;
    @Column(name = "closing_diff", nullable = false)
    private Integer closingDiff;
    @Column(name = "closing_rate", nullable = false)
    private Double closingRate;
    @Column(name = "start_price", nullable = false)
    private Integer startPrice;
    @Column(name = "high_price", nullable = false)
    private Integer highPrice;
    @Column(name = "low_price", nullable = false)
    private Integer lowPrice;
    @Column(name = "trade_vol", nullable = false)
    private String tradeVol;
    @Column(name = "trade_amount", nullable = false)
    private String tradeAmount;
    @Column(name = "stock_count", nullable = false)
    private Integer stockCount;
    @Column(name = "market_cap", nullable = false)
    private String marketCap;
}