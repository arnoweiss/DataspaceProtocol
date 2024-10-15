## Static Rendering and Web Deployment

This repository contains the set of artifacts that make up the normative
and non-normative sections of the Dataspace Protocol. All artifacts are
bundled by the [respec framework](https://www.respec.org) which takes care
of rendering a static website. The following extensions to the basic markdown
syntax are used in this specification project. Keep them handy and navigating
the document will be easy.

- Referencing an external specification document. [Respec Docs](https://respec.org/docs/#references-0)
    - with identifier inline `[[foreign-spec-id]]`
    - with the foreign spec's display name inline `[[[foreign-spec-id]]]`
    - referencing a particular section in a remote document works via ordinary markdown links. The reference has to be added to the `References` section manually.
- Defining terminology: A term is defined by wrapping it in `<dfn>Defineable</dfn>`. [Respec Docs](https://respec.org/docs/#definitions-and-linking)
- Custom section IDs: If various sections have the same heading, they must be given a unique id manually via `{#my-custom-section-id}` that can then be used for referencing it. [Respec Docs](https://respec.org/docs/#example-specifying-a-custom-id-for-a-heading)
- Referencing within the document. Please note that despite separation in multiple markdown files, there is only one html document. References to sections must be flat `(#section)` instead of path-based `../catalog/catalog.protocol.md#response-types`.
    - with the sections number and display name inline `[[[#my-section-id]]]`
    - If that's not desired, ordinary links work as well. `[my custom link](#my-section-id)`
    - referencing terminology: `[=Defineable=]`. This will work out of the box with Plurals such that `[=Definables=]` refers to the definition of `<dfn>Defineable</dfn>`.
- Code blocks work natively like in markdown.

## Eclipse Specification Process

This Eclipse Foundation open project is governed by the Eclipse Foundation
Specification Process and operates under the terms of the Eclipse IP Policy.

* https://www.eclipse.org/projects/efsp/
* https://www.eclipse.org/org/documents/Eclipse_IP_Policy.pdf

## Eclipse Contributor Agreement

In order to be able to contribute to Eclipse Foundation projects you must
electronically sign the Eclipse Contributor Agreement (ECA).

* http://www.eclipse.org/legal/ECA.php

The ECA provides the Eclipse Foundation with a permanent record that you agree
that each of your contributions will comply with the commitments documented in
the Developer Certificate of Origin (DCO). Having an ECA on file associated with
the email address matching the "Author" field of your contribution's Git commits
fulfills the DCO's requirement that you sign-off on your contributions.

For more information, please see the Eclipse Committer Handbook:
https://www.eclipse.org/projects/handbook/#resources-commit

## Contact

Contact the project developers via the project's "dev" list.

* https://accounts.eclipse.org/mailing-list/dataspace-protocol-base-dev

