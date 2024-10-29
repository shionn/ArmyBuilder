package armybuilder.db.dbo.unit.option;

import armybuilder.db.dbo.option.UnitOptionType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UnitOptionValue {
	private UnitOptionType option;
	private String value;
}
