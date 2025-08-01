/*
 *  Copyright (c) 2024 Metaform Systems, Inc.
 *
 *  This program and the accompanying materials are made available under the
 *  terms of the Apache License, Version 2.0 which is available at
 *  https://www.apache.org/licenses/LICENSE-2.0
 *
 *  SPDX-License-Identifier: Apache-2.0
 *
 *  Contributors:
 *       Metaform Systems, Inc. - initial API and implementation
 *
 */

package org.eclipse.dsp.schema.transfer;

import org.eclipse.dsp.schema.fixtures.AbstractSchemaTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static com.networknt.schema.InputFormat.JSON;
import static org.assertj.core.api.Assertions.assertThat;

public class TransferRequestMessageSchemaTest extends AbstractSchemaTest {

    @Test
    void verifyRequestSchema() throws IOException {
        var node = mapper.readTree(getClass().getResourceAsStream("/transfer/example/transfer-request-message.json"));
        assertThat(schema.validate(node)).isEmpty();
    }

    @Test
    void verifyMinimalRequestSchema() {
        assertThat(schema.validate(MINIMAL_REQUEST, JSON)).isEmpty();
        assertThat(schema.validate(NO_DA_ENDPOINT, JSON)).isEmpty();
    }

    @BeforeEach
    void setUp() {
        setUp("/transfer/transfer-request-message-schema.json");
    }

    private static final String MINIMAL_REQUEST = """
            {
              "@context": [
                "https://w3id.org/dspace/2025/1/context.jsonld"
              ],
              "@type": "TransferRequestMessage",
              "consumerPid": "urn:uuid:32541fe6-c580-409e-85a8-8a9a32fbe833",
              "agreementId": "urn:uuid:e8dc8655-44c2-46ef-b701-4cffdc2faa44",
              "format": "example:HTTP_PUSH",
              "callbackAddress": "https://example.com/callback"
            }
            """;

    private static final String NO_DA_ENDPOINT = """
            {
              "@context": [
                "https://w3id.org/dspace/2025/1/context.jsonld"
              ],
              "@type": "TransferRequestMessage",
              "consumerPid": "urn:uuid:32541fe6-c580-409e-85a8-8a9a32fbe833",
              "agreementId": "urn:uuid:e8dc8655-44c2-46ef-b701-4cffdc2faa44",
              "format": "example:HTTP_PUSH",
              "dataAddress": {
                "@type": "DataAddress",
                "endpointType": "https://w3id.org/idsa/v4.1/HTTP"
              },
              "callbackAddress": "https://example.com/callback"
            }
            """;
}
