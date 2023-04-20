package idusw.springboot.boardksh.domain;
import lombok.*; // 애노테이션 기반 상용코드(boiler-plate code)를 생성해주는 라이브러리

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@ToString
@EqualsAndHashCode
public class Member {
    // DTO : Data Transfer Object, 데이터 전송 객체 Controller -> Service -> Controller -> View
    // Domain(실제 업무 영역) Object
    private Long seq;
    private String email;
    private String name;
    private String pw;
}
