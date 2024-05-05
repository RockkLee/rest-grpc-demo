package idv.sheng.app.dto;

import idv.sheng.domain.entity.Greeting;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MsgDto {
    private int respCode;
    private String msg;
}