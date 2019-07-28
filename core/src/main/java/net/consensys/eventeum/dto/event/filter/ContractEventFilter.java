package net.consensys.eventeum.dto.event.filter;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.EqualsAndHashCode;
import net.consensys.eventeum.constant.Constants;
import net.consensys.eventeum.dto.event.filter.correlationId.CorrelationIdStrategy;

import java.math.BigInteger;

import javax.persistence.CollectionTable;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;

/**
 * Represents the details of a contract event filter.
 *
 * @author Craig Williams <craig.williams@consensys.net>
 */
@Entity
@Data
@EqualsAndHashCode
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ContractEventFilter {

    @Id
    private String id;

    private String contractAddress;

    private String node = Constants.DEFAULT_NODE_NAME;

    @Embedded
    //@JoinTable(joinColumns=@JoinColumn(name="contract_event_filter_id"))
    private ContractEventSpecification eventSpecification;
    
    @Embedded
    private CorrelationIdStrategy correlationIdStrategy;

    private BigInteger startBlock;
}
