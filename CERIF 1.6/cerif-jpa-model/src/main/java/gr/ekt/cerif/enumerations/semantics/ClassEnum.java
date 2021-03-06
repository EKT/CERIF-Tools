package gr.ekt.cerif.enumerations.semantics;

import gr.ekt.cerif.CerifEntity;
import gr.ekt.cerif.entities.base.OrganisationUnit;
import gr.ekt.cerif.entities.base.Person;
import gr.ekt.cerif.entities.base.Project;
import gr.ekt.cerif.entities.infrastructure.Equipment;
import gr.ekt.cerif.entities.infrastructure.Facility;
import gr.ekt.cerif.entities.infrastructure.Service;
import gr.ekt.cerif.entities.result.ResultPatent;
import gr.ekt.cerif.entities.result.ResultProduct;
import gr.ekt.cerif.entities.result.ResultPublication;
import gr.ekt.cerif.entities.second.CurriculumVitae;
import gr.ekt.cerif.entities.second.Citation;
import gr.ekt.cerif.entities.second.Country;
import gr.ekt.cerif.entities.second.Currency;
import gr.ekt.cerif.entities.second.ElectronicAddress;
import gr.ekt.cerif.entities.second.Event;
import gr.ekt.cerif.entities.second.ExpertiseAndSkills;
import gr.ekt.cerif.entities.second.FederatedIdentifier;
import gr.ekt.cerif.entities.second.Funding;
import gr.ekt.cerif.entities.second.GeographicBoundingBox;
import gr.ekt.cerif.entities.second.Indicator;
import gr.ekt.cerif.entities.second.Language;
import gr.ekt.cerif.entities.second.Measurement;
import gr.ekt.cerif.entities.second.Medium;
import gr.ekt.cerif.entities.second.Metrics;
import gr.ekt.cerif.entities.second.PostalAddress;
import gr.ekt.cerif.entities.second.Prize;
import gr.ekt.cerif.entities.second.Qualification;
import gr.ekt.cerif.features.semantics.ClassScheme;

public enum ClassEnum {

	PERSON("cf7799e0-3477-11e1-b86c-0800200c9a66","Person", Person.class),
	PROJECT("cf7799e1-3477-11e1-b86c-0800200c9a66","Project", Project.class),
	ORGANISATION("cf7799e2-3477-11e1-b86c-0800200c9a66","Organisation", OrganisationUnit.class),
	PATENT("cf7799e3-3477-11e1-b86c-0800200c9a66","Patent", ResultPatent.class),
	PRODUCT("cf7799e4-3477-11e1-b86c-0800200c9a66","Product", ResultProduct.class),
	PUBLICATION("cf7799e5-3477-11e1-b86c-0800200c9a66","Publication", ResultPublication.class),
	FUNDING("cf7799e6-3477-11e1-b86c-0800200c9a66","Funding", Funding.class),
	FACILITY("cf7799e7-3477-11e1-b86c-0800200c9a66","Facility", Facility.class),
	EQUIPMENT("cf7799e8-3477-11e1-b86c-0800200c9a66","Equipment", Equipment.class),
	SERVICE("cf7799e9-3477-11e1-b86c-0800200c9a66","Service", Service.class),
	CITATION("68aa07f0-34c9-11e1-b86c-0800200c9a66","Citation", Citation.class),
	CURRICULUM_VITAE("68aa07f1-34c9-11e1-b86c-0800200c9a66","Curriculum Vitae", CurriculumVitae.class),
	ELECTRONIC_ADDRESS("68aa07f2-34c9-11e1-b86c-0800200c9a66","Electronic Address", ElectronicAddress.class),
	POSTAL_ADDRESS("68aa07f3-34c9-11e1-b86c-0800200c9a66","Postal Address", PostalAddress.class),
	EVENT("68aa07f4-34c9-11e1-b86c-0800200c9a66","Event", Event.class),
	MEDIUM("a9332fbf-e5a9-430f-8e78-26bc3610dfe3","Medium", Medium.class),
	METRICS("36890f4f-6f60-4f52-9853-b294afb41637","Metrics", Metrics.class),
	COUNTRY("b6ebf4db-55f0-49d6-8868-37c1ff3a951e","Country", Country.class),
	CURRENCY("ec809f55-7124-4b5e-ba8b-db189d8422e2","Currency", Currency.class),
	EXPERTISE_AND_SKILLS("ae5f5b3f-4868-4534-94fd-7482cb460b6f","Expertise and Skills", ExpertiseAndSkills.class),
	LANGUAGE("717eb2b5-279b-4de3-a4be-4a96ffe73b29","Language", Language.class),
	PRIZE("53dbf914-6219-4846-9ef6-e1d02d6a5597","Prize", Prize.class),
	GEOGRAPHIC_BOUNDING_BOX("1fa40282-876d-11e4-b116-123b93f75cba", "Geographic Bounding Box", GeographicBoundingBox.class),
	QUALIFICATION("68aa07f5-34c9-11e1-b86c-0800200c9a66","Qualification", Qualification.class),
	FEDERATED_IDENTIFIER("a1e51365-b7c4-4bdb-bbd1-0530840148be","Federated Identifier", FederatedIdentifier.class),
	MEASUREMENT("1cc0fbd8-a160-41df-9af8-d436e6a5296f","Measurement", Measurement.class),
	INDICATOR("ed96ef79-f77d-4aaf-8c19-f727bbb49937","Indicator", Indicator.class),
	CLASSIFICATION("613b117e-980e-4051-8876-8524cd498caf","Classification", gr.ekt.cerif.features.semantics.Class.class),
	CLASSIFICATION_SCHEME("4c93b3b2-d5ff-442c-9b28-4a028305bcf1","Classification Scheme", ClassScheme.class),
	RESEARCH_INFRASTRUCTURE("cf7799ea-3477-11e1-b86c-0800200c9a66","Research Infrastructure"),
	RESEARCH_OUTPUT("627e286f-a8ae-46c6-891e-0218e6b2f1a8","Research Output"),
	DR("8f558c1a-be74-4d3c-8f19-fdd645b61c0a","Dr"),
	MISS("bd2600ce-3bcf-4193-be07-8beaa76b91dd","Miss"),
	MR("3bd6c3dd-7132-465e-923b-d7ceeeda93d6","Mr"),
	MRS("2e7190cc-51b9-49d3-a11d-bc739e3dabfb","Mrs"),
	MS("09bc5967-6b4c-4815-ac8e-1a5a5eb8ee03","Ms"),
	PROFESSOR("3bb53320-1cfd-11e1-8bc2-0800200c9a66","Professor"),
	REVEREND("27a398fa-0ea6-4445-95de-53a32e839b4d","Reverend"),
	SIR("2a5de419-4144-42fe-8e4b-73dca8c54f8d","Sir"),
	ASSOCIATE("a27e5ca7-3d20-4272-9054-7db550e2a053","Associate"),
	DAME("a944b6ae-e2be-40e0-a33e-e5da5db6ea89","Dame"),
	EMERITUS("1e83ced2-47e7-4e01-a7b9-ec78291d979c","Emeritus"),
	COLONEL("d0d64e35-d7dd-443d-8d77-96ee4ad8023b","Colonel"),
	AFFILIATION("980965b0-1cd5-11e1-8bc2-0800200c9a66","Affiliation"),
	SUBAFFILIATION("081e85f0-1cd7-11e1-8bc2-0800200c9a66","Subaffiliation"),
	HEAD("6125f750-1cd7-11e1-8bc2-0800200c9a66","Head"),
	EMPLOYEE("c302c2f0-1cd7-11e1-8bc2-0800200c9a66","Employee"),
	MEMBER("cb3e0010-1cd7-11e1-8bc2-0800200c9a66","Member"),
	DIRECTOR("68971130-1cd8-11e1-8bc2-0800200c9a66","Director"),
	DEPUTY_DIRECTOR("885eeb00-1cf6-11e1-8bc2-0800200c9a66","Deputy Director"),
	DEAN("57f7a7d0-1cfc-11e1-8bc2-0800200c9a66","Dean"),
	PRINCIPLE("612163a0-1cfc-11e1-8bc2-0800200c9a66","Principle"),
	HEAD_OF_DEPARTMENT("68cdce40-1cfc-11e1-8bc2-0800200c9a66","Head of Department"),
	GROUP_LEADER("7210b760-1cfc-11e1-8bc2-0800200c9a66","Group Leader"),
	MANAGER("79a2e340-1cfc-11e1-8bc2-0800200c9a66","Manager"),
	SPOKESPERSON("8418a710-1cfc-11e1-8bc2-0800200c9a66","Spokesperson"),
	FELLOW("94d55210-1cfc-11e1-8bc2-0800200c9a66","Fellow"),
	REVIEWER("9ef1ab40-1cfc-11e1-8bc2-0800200c9a66","Reviewer"),
	AUDITOR("c9a24a22-d3f2-4b15-aa06-cb512b2f1341","Auditor"),
	CONTRACTOR("abf21190-1cfc-11e1-8bc2-0800200c9a66","Contractor"),
	SUBCONTRACTOR("b272a660-1cfc-11e1-8bc2-0800200c9a66","Subcontractor"),
	ENGINEER("057a7d50-1cfe-11e1-8bc2-0800200c9a66","Engineer"),
	ADMINISTRATOR("b9bd41f0-1cfc-11e1-8bc2-0800200c9a66","Administrator"),
	TECHNICIAN("8adcdf20-1cfd-11e1-8bc2-0800200c9a66","Technician"),
	ACADEMIC_TEACHING_ONLY("7a642fac-777a-43b7-a0c1-90b88428e125","Academic Teaching only"),
	RESEARCH_ASSOCIATE("df5ec85e-c645-449f-9473-41c9f9923cb7","Research Associate"),
	ACADEMIC_RESEARCH("fd742fb8-fa7f-40b4-a015-c7deb93902f6","Academic Research"),
	SECRETARY("c6e02460-1cfc-11e1-8bc2-0800200c9a66","Secretary"),
	RESEARCHER("ebd55ab0-1cfc-11e1-8bc2-0800200c9a66","Researcher"),
	JUNIOR_RESEARCHER("f401a3b0-1cfc-11e1-8bc2-0800200c9a66","Junior Researcher"),
	SENIOR_RESEARCHER("faf322c0-1cfc-11e1-8bc2-0800200c9a66","Senior Researcher"),
	CONSULTANT("04c3f400-1cfd-11e1-8bc2-0800200c9a66","Consultant"),
	JUNIOR_CONSULTANT("0bb17b70-1cfd-11e1-8bc2-0800200c9a66","Junior Consultant"),
	SENIOR_CONSULTANT("13633d40-1cfd-11e1-8bc2-0800200c9a66","Senior Consultant"),
	LECTURER("1a3c5250-1cfd-11e1-8bc2-0800200c9a66","Lecturer"),
	JUNIOR_LECTURER("23b16f00-1cfd-11e1-8bc2-0800200c9a66","Junior Lecturer"),
	SENIOR_LECTURER("2b20d0a0-1cfd-11e1-8bc2-0800200c9a66","Senior Lecturer"),
	GUEST_LECTURER("33661fe0-1cfd-11e1-8bc2-0800200c9a66","Guest Lecturer"),
	ASSISTANT_PROFESSOR("45aec210-1cfd-11e1-8bc2-0800200c9a66","Assistant Professor"),
	HONORARY_PROFESSOR("4dfbb270-1cfd-11e1-8bc2-0800200c9a66","Honorary Professor"),
	VISITING_PROFESSOR("55ddd310-1cfd-11e1-8bc2-0800200c9a66","Visiting Professor"),
	DOCTOR__MED_("5d1534c0-1cfd-11e1-8bc2-0800200c9a66","Doctor (med)"),
	RESEARCH_FELLOW("64af4fe0-1cfd-11e1-8bc2-0800200c9a66","Research Fellow"),
	POSTDOC("6c68b2d0-1cfd-11e1-8bc2-0800200c9a66","Postdoc"),
	PHD_STUDENT("727f6240-1cfd-11e1-8bc2-0800200c9a66","PhD Student"),
	RESEARCH_ASSISTANT("7a510820-1cfd-11e1-8bc2-0800200c9a66","Research Assistant"),
	READER("80cae630-1cfd-11e1-8bc2-0800200c9a66","Reader"),
	TEACHING_FELLOW("91784ef0-1cfd-11e1-8bc2-0800200c9a66","Teaching Fellow"),
	TEACHING_ASSISTANT("99c34380-1cfd-11e1-8bc2-0800200c9a66","Teaching Assistant"),
	CASUAL("a3bf6a80-1cfd-11e1-8bc2-0800200c9a66","Casual"),
	EXPERT("a9fc3f90-1cfd-11e1-8bc2-0800200c9a66","Expert"),
	INVESTIGATOR("e7036eeb-aca5-48d6-9ba1-c4c1d8fd96eb","Investigator"),
	PRINCIPAL_INVESTIGATOR("b0e11470-1cfd-11e1-8bc2-0800200c9a66","Principal Investigator"),
	CO_INVESTIGATOR("bc34dc30-1cfd-11e1-8bc2-0800200c9a66","Co-Investigator"),
	COLLABORATOR("541b4224-a784-49b7-a341-8275ce874ada","Collaborator"),
	HIGHLY_QUALIFIED_PERSONEL("65c14308-310c-4198-be0b-43a6a1697038","Highly Qualified Personel"),
	RESEARCH_STUDENT("2a9173a6-3725-43f3-aed1-1d754b30f57d","Research Student"),
	SUPPORTER("eda28bc5-34c5-11e1-b86c-0800200c9a66","Supporter"),
	PROJECT_OFFICER("254cb300-1cfe-11e1-8bc2-0800200c9a66","Project Officer"),
	COORDINATOR("c31d3380-1cfd-11e1-8bc2-0800200c9a66","Coordinator"),
	PARTICIPANT("ddc3dd10-1cfd-11e1-8bc2-0800200c9a66","Participant"),
	CONTRIBUTOR("e4d7b130-1cfd-11e1-8bc2-0800200c9a66","Contributor"),
	PERFORMER("ee155a46-9850-48aa-98c2-e70ecb0f5d3b","Performer"),
	CHOREOGRAPHER("92e7478e-5a7c-4c72-a14e-a5770619251e","Choreographer"),
	INTERVIEWEE("2b3ba8f1-5620-42c9-8549-7d34ed37f968","Interviewee"),
	SPEAKER("d1ee35f1-c4c6-4651-a760-06a3828a61c1","Speaker"),
	PANEL_PARTICIPANT("1ca8d2bc-9424-4df4-ae4b-8ce65239c770","Panel Participant"),
	PROGRAMME_COMMITTEE_MEMBER("1869a08e-3257-457b-9278-ed32bd915ee8","Programme Committee Member"),
	REPORTER("dc42714f-56de-441f-9161-a51d8edbcb8d","Reporter"),
	RAPPORTEUR("86bacee1-49d8-429d-97aa-5f4918d3ae88","Rapporteur"),
	PEER_REVIEWER("d9a6b8e4-38af-4492-b178-3326173ec657","Peer Reviewer"),
	ORGANISER("b4ba809e-60d7-411c-af62-792100c45341","Organiser"),
	CONTACT("2af3d7c0-1cfe-11e1-8bc2-0800200c9a66","Contact"),
	APPLICANT("33551370-1cfe-11e1-8bc2-0800200c9a66","Applicant"),
	AUTHOR("49815870-1cfe-11e1-8bc2-0800200c9a66","Author"),
	AUTHOR__NUMBERED_("505eb340-1cfe-11e1-8bc2-0800200c9a66","Author (numbered)"),
	AUTHOR__PERCENTAGE_("5a4c3440-1cfe-11e1-8bc2-0800200c9a66","Author (percentage)"),
	CREATOR("60f2a090-1cfe-11e1-8bc2-0800200c9a66","Creator"),
	EDITOR("708b3df0-1cfe-11e1-8bc2-0800200c9a66","Editor"),
	TRANSLATOR("7ef398b1-1cfe-11e1-8bc2-0800200c9a66","Translator"),
	PUBLISHER("7ef398b2-1cfe-11e1-8bc2-0800200c9a66","Publisher"),
	COMMISSIONER("7ef398b3-1cfe-11e1-8bc2-0800200c9a66","Commissioner"),
	GROUP_AUTHORS("7ef398b4-1cfe-11e1-8bc2-0800200c9a66","Group Authors"),
	SUBJECT("7ef3bfc0-1cfe-11e1-8bc2-0800200c9a66","Subject"),
	ILLUSTRATOR("7e2e67e4-e085-406c-a9c3-2a3df2bfc376","Illustrator"),
	GUEST_EDITOR("5282d01e-f788-42b5-9ccb-eb8cc0626d4b","Guest Editor"),
	PATENTEE("5b6b6bf2-c949-4c9e-ab4c-ffaa196b8355","Patentee"),
	HOLDER("74e43aa3-233d-4a59-b9bf-0bd733c9e9f8","Holder"),
	DESIGNER("d03c6c91-1c65-442e-82e2-a2194b0e1907","Designer"),
	ARTIST("97fb8809-d23d-4826-b99d-6b5d666e1f33","Artist"),
	CONSTRUCTOR("62226b46-2ea3-46f4-b924-80ea42055587","Constructor"),
	COMPOSER("b14b3a56-64c0-4d59-ad64-7d7af09ea529","Composer"),
	PROGRAMMER("aa82a7f8-8713-43f2-b7b4-e4d2196b1a3c","Programmer"),
	ANALYST("cd5bb616-a187-4600-b2d2-0eac76a3be63","Analyst"),
	VALIDATOR("6d95cff9-0ae3-4dc2-8566-5a31fd8e75f9","Validator"),
	TESTER("f94f7ec1-263a-4898-8286-4e7ba44af0d1","Tester"),
	MENTOR("6b2b7d22-3491-11e1-b86c-0800200c9a66","Mentor"),
	SUPERVISOR("6b2b7d23-3491-11e1-b86c-0800200c9a66","Supervisor"),
	CO_SUPERVISOR("ab0ed712-6e50-46a5-8fa2-5d9b87c27e6d","Co-Supervisor"),
	EXTERNAL_SUPERVISOR("3ccd035b-bc79-477e-aa6c-0bd3606f85c8","External Supervisor"),
	ADVISOR("81d0d105-216f-42f0-8c96-a87ba2adfa41","Advisor"),
	COLLEAGUE("1d689234-c537-4bba-b59a-2d85e1efcd1d","Colleague"),
	CO_RESEARCHER("78883ba6-a5ac-45d4-a2e2-20b3f7f43a63","Co-Researcher"),
	FUNDER("eda28bc0-34c5-11e1-b86c-0800200c9a66","Funder"),
	INKIND_CONTRIBUTOR("69948e23-7c53-4437-a33e-17c051b9281b","Inkind-Contributor"),
	PARTNER("c77f9885-b80d-466a-9097-9768720c0fe1","Partner"),
	SPONSOR("f27bedda-f04c-4d32-a026-d4955bb65227","Sponsor"),
	PART("eda28bc1-34c5-11e1-b86c-0800200c9a66","Part"),
	RELATION("eda28bc2-34c5-11e1-b86c-0800200c9a66","Relation"),
	ACQUISITION("eda28bc3-34c5-11e1-b86c-0800200c9a66","Acquisition"),
	TAKEOVER("eda28bc4-34c5-11e1-b86c-0800200c9a66","Takeover"),
	STAKEHOLDER("eda28bc6-34c5-11e1-b86c-0800200c9a66","Stakeholder"),
	MERGER("eda28bc7-34c5-11e1-b86c-0800200c9a66","Merger"),
	DERIVED_FROM("eda28bc8-34c5-11e1-b86c-0800200c9a66","Derived from"),
	BUILT_ON("eda28bc9-34c5-11e1-b86c-0800200c9a66","Built on"),
	SUCCESSOR("eda28bca-34c5-11e1-b86c-0800200c9a66","Successor"),
	PREDECESSOR("eda28bcb-34c5-11e1-b86c-0800200c9a66","Predecessor"),
	SPIN_OFF("eda28bcc-34c5-11e1-b86c-0800200c9a66","Spin-Off"),
	IPR_CLAIM("eda2b2d0-34c5-11e1-b86c-0800200c9a66","IPR Claim"),
	CURATOR("eda2b2d2-34c5-11e1-b86c-0800200c9a66","Curator"),
	AUTHOR_INSTITUTION("eda2b2d3-34c5-11e1-b86c-0800200c9a66","Author Institution"),
	PUBLISHER_INSTITUTION("eda2b2d4-34c5-11e1-b86c-0800200c9a66","Publisher Institution"),
	REVIEWER_INSTITUTION("eda2b2d5-34c5-11e1-b86c-0800200c9a66","Reviewer Institution"),
	EXTERNAL_ORGANISATION("eda2b2d6-34c5-11e1-b86c-0800200c9a66","External Organisation"),
	COOPERATION("eda2b2d7-34c5-11e1-b86c-0800200c9a66","Cooperation"),
	ORIGINATOR("eda2b2d8-34c5-11e1-b86c-0800200c9a66","Originator"),
	FUNDING_PROGRAMME_DOCUMENT("eda2b2d9-34c5-11e1-b86c-0800200c9a66","Funding Programme Document"),
	CALL_DOCUMENT("eda2b2da-34c5-11e1-b86c-0800200c9a66","Call Document"),
	TENDER_DOCUMENT("eda2b2db-34c5-11e1-b86c-0800200c9a66","Tender Document"),
	GIFT_DOCUMENT("eda2b2dc-34c5-11e1-b86c-0800200c9a66","Gift Document"),
	ACCESS_POLICY_DOCUMENT("eda2b2dd-34c5-11e1-b86c-0800200c9a66","Access Policy Document"),
	ACCESS_TERMS_AND_CONDITIONS("80be3ed3-5677-4676-b466-fa9f61d8af42","Access Terms and Conditions"),
	USAGE_DOCUMENT("eda2b2de-34c5-11e1-b86c-0800200c9a66","Usage Document"),
	MASTER_("a32a9785-0d15-48ba-aca8-0be319578e5e","Master "),
	DOCTORATE("f7d5892b-8be3-42fa-8d4b-e18fe9bed062","Doctorate"),
	HIGHER_DOCTORATE("73451d3c-9afa-4484-8404-cd1518ef508b","Higher Doctorate"),
	CONFERENCE("909ea9bd-e460-497e-8950-9ad306675ae9","Conference"),
	FELLOWSHIP("d7fe4a84-93a2-46f1-b1fa-165d518fba47","Fellowship"),
	NETWORKING("67f2c93f-37c9-4311-99e7-61d40d53b265","Networking"),
	INFRASTRUCTURE("4af214d4-579f-4396-aef6-9e3ce879c6be","Infrastructure"),
	STUDENTSHIP("f74a1e84-6c96-4cab-bd51-da931c9f226d","Studentship"),
	RESEARCH_PROJECT("0bd2d47a-8688-4758-a63c-45e76825a0f6","Research Project"),
	CONTRACT_RESEARCH("c0441e0d-42e4-4dd1-84bc-9cd345b911f5","Contract Research"),
	EARLY_CAREER_RESEARCH_PROJECT("28de21fc-ab80-49dc-8725-41d033e81028","Early Career Research Project"),
	CONSULTANCY("f81c03f9-7d15-4f61-90e6-bbb5c38c9a6c","Consultancy"),
	COMMERCIALISATION("fb837c4d-73da-448c-a554-383d671bb3eb","Commercialisation"),
	CONTINUING_PROFESSIONAL_DEVELOPMENT("2a527079-481f-491a-8e3a-dbc79b271c48","Continuing Professional Development"),
	ENTERPRISE("6ee92d54-322f-4a55-b2c6-4388ad890754","Enterprise"),
	KTP("7b20769e-cbf6-4955-9844-bdb6b1cd2bf6","KTP"),
	PROGRAMME_GRANT("6cad7850-82ea-42d6-9a7c-fbcc6753848e","Programme Grant"),
	ATTENDANCE("1d4e7a48-d5f9-427a-bd16-e5b503967071","Attendance"),
	HOSTING("6cc796c4-84f4-448c-9018-7efc47197627","Hosting"),
	SPECIFIED_NAMED_PERSON("bd95c4c6-7882-400c-bde9-b20df6f4f87e","Specified Named Person"),
	GENERAL_FELLOWSHIP("ee8f08de-b0be-4e2b-a90c-63d08433a56d","General Fellowship"),
	TRAVEL("fe3ef479-0a35-4b3e-93e8-f54800c98857","Travel"),
	WORKSHOP("33fd9fc9-48b5-41c5-a2f6-b97c6996e432","Workshop"),
	BUILDING("fe88ae1b-4eaa-43e6-b8df-479cc0609b8b","Building"),
	COLLABORATIVE("37a7dad6-2487-4df8-9b41-d6c6663bba4b","Collaborative"),
	GENERAL_STUDENTSHIP("65c07ebe-0836-49af-be78-82a36a629b30","General Studentship"),
	BLOCK_GRANT("08431e7e-4a62-42e3-80d7-5941126752c1","Block-Grant"),
	CONCEPTUALISED("8dc4b088-6e93-4d3a-ab67-60c0d287868b","Conceptualised"),
	INTERNAL_REVIEWED("edb73a76-2b48-4eca-991e-1b0b6fbe524a","Internal-Reviewed"),
	SUBMITTED("20a14a62-85b2-42fe-bd46-d9f07a752abc","Submitted"),
	NOT_SUBMITTED("444ababa-bfe8-42fc-af0c-15464545ef98","Not Submitted"),
	AWARDED("eda2b2e0-34c5-11e1-b86c-0800200c9a66","Awarded"),
	REJECTED("f97f3ccd-13c0-46ce-9cb3-98ebb58f39fd","Rejected"),
	ASSUMED_UNSUCCESSFUL("0bb4df81-4e9a-41ae-947c-5ae3bde26abd","Assumed Unsuccessful"),
	WITHDRAWN("bfcdfa1c-6d27-4012-9468-1c91cecbba45","Withdrawn"),
	CLOSED("276a4f0c-6729-47df-b8d3-7cd1cb3c7e67","Closed"),
	ISSUER("eda2b2e2-34c5-11e1-b86c-0800200c9a66","Issuer"),
	RESPONSIBLE("eda2b2e3-34c5-11e1-b86c-0800200c9a66","Responsible"),
	FINANCIER("eda2b2e4-34c5-11e1-b86c-0800200c9a66","Financier"),
	COST_CENTER("eda2b2e5-34c5-11e1-b86c-0800200c9a66","Cost Center"),
	FUNDING_PROGRAMME("eda2b2e6-34c5-11e1-b86c-0800200c9a66","Funding Programme"),
	CALL("eda2b2e7-34c5-11e1-b86c-0800200c9a66","Call"),
	TENDER_("eda2b2e8-34c5-11e1-b86c-0800200c9a66","Tender "),
	GIFT("eda2b2e9-34c5-11e1-b86c-0800200c9a66","Gift"),
	INTERNAL_FUNDING("40d72109-28ba-4110-a3e9-23ecca3bb795","Internal Funding"),
	ACADEMIC_INSTITUTE("eda2b2ec-34c5-11e1-b86c-0800200c9a66","Academic Institute"),
	UNIVERSITY("eda2b2ed-34c5-11e1-b86c-0800200c9a66","University"),
	UNIVERSITY_COLLEGE("eda2b2ee-34c5-11e1-b86c-0800200c9a66","University College"),
	RESEARCH_INSTITUTE("eda2b2ef-34c5-11e1-b86c-0800200c9a66","Research Institute"),
	STRATEGIC_RESEARCH_INSITUTE("eda2b2f0-34c5-11e1-b86c-0800200c9a66","Strategic Research Insitute"),
	COMPANY("eda2b2f1-34c5-11e1-b86c-0800200c9a66","Company"),
	SME("eda2b2f2-34c5-11e1-b86c-0800200c9a66","SME"),
	GOVERNMENT("eda2b2f3-34c5-11e1-b86c-0800200c9a66","Government"),
	HIGHER_EDUCATION("eda2b2f4-34c5-11e1-b86c-0800200c9a66","Higher Education"),
	PRIVATE_NON_PROFIT("eda2b2f5-34c5-11e1-b86c-0800200c9a66","Private non-profit"),
	INTERGOVERNMENTAL("13d1fa53-18f0-4bf2-88ca-2d2df474f404","Intergovernmental"),
	CHARITY("ecaac6d5-b281-4f0a-a6fa-2c155aa51002","Charity"),
	NATIONAL_HEALTH_SERVICE("1d9ffa49-8af2-4844-a228-5498846b8da2","National Health Service"),
	EU_GOVERNMENT_BODIES__INCLUDING_EC_("3a48310a-fb4a-4177-bb92-cf1aeb0efebb","EU Government Bodies (including EC)"),
	EU_OTHER_("c54a63e9-d59d-4bf9-9b81-23b538de8fd6","EU Other "),
	OTHER_SERVICES("0e737bcb-2fec-4c40-90f7-f9aefd8dac8f","Other Services"),
	UK_BASED_INDUSTRY_COMMERCE__N__PUBLIC_CORPORATIONS("dd8df2e3-c481-452f-b9c9-6e426386017f","UK-based Industry Commerce & Public Corporations"),
	RESEARCH_COUNCILS("032fcb89-8340-4fe3-a5e4-b1191cf6bc31","Research Councils"),
	UK_BASED_CHARITIES("874653df-8ced-4ae6-a8ed-449c42f18082","UK-based Charities"),
	UK_CENTRAL_LOCAL_GOVERNMENT_HEALTH_AND_HOSPITAL_("3093abcb-c0d7-4cb7-a5a6-82f40e798811","UK Central / Local Government Health and Hospital "),
	EU_BASED_CHARITIES_("bf682b89-0ce7-4fdc-ac67-35bfd2be436e","EU-based Charities "),
	OTHER_OVERSEAS("abb6de22-ad1b-439a-944f-9e90544a2c0f","Other Overseas"),
	EU_BASED_INDUSTRY("b2a4dd0d-2bbb-4089-8826-99894262e7b3","EU-based Industry"),
	EU_COMMERCE__N__PUBLIC_CORPORATIONS("7c32bcd0-0c34-4103-8d10-a3908b041b06","EU Commerce & Public Corporations"),
	NON_EU_BASED_INDUSTRY("46df9200-e355-45e7-84e7-fdda25dc14ac","Non-EU-based Industry"),
	NON_EU_BASED_COMMERCE__N__PUBLIC_CORPORATIONS_("b1ec752b-de87-4377-9c28-87b84ac17845","Non-EU-based Commerce & Public Corporations "),
	NON_EU_BASED_CHARITIES("92c1c6c0-b3ba-4edf-b34c-bc6ee14bc756","Non-EU-based Charities"),
	OTHER_SOURCES_("5ca5a3e7-70b8-4f39-a480-b4989f67e7da","Other Sources "),
	RESEARCH_DONATIONS("8c6c81e3-6efc-49a6-a7a7-5cd13345d50f","Research Donations"),
	INSTITUTION_BASED("78e3de8c-ee32-4ec8-8cc0-6b5f664e6ca1","Institution-based"),
	KTP_GRANTS("62d67cb9-2fc5-4afb-a95f-582d55ed916b","KTP Grants"),
	NON_EU_OTHER("94b8e8e8-5279-4bc2-8b15-b96dc3dc7ff5","Non-EU Other"),
	UK_BASED_GOVERNMENT_BODIES("af3b394e-61f3-431d-8a90-f7cb972993e7","UK-based Government Bodies"),
	UK_OTHER_SOURCES("ab2e7af8-7043-4533-a60b-9752f28acbdd","UK Other Sources"),
	BOOK("eda2b2f6-34c5-11e1-b86c-0800200c9a66","Book"),
	BOOK_REVIEW("eda2b2f7-34c5-11e1-b86c-0800200c9a66","Book Review"),
	BOOK_CHAPTER_ABSTRACT("eda2b2f8-34c5-11e1-b86c-0800200c9a66","Book Chapter Abstract"),
	BOOK_CHAPTER_REVIEW("eda2b2f9-34c5-11e1-b86c-0800200c9a66","Book Chapter Review"),
	INBOOK("eda2d9e0-34c5-11e1-b86c-0800200c9a66","Inbook"),
	ANTHOLOGY("eda2d9e1-34c5-11e1-b86c-0800200c9a66","Anthology"),
	MONOGRAPH("eda2d9e2-34c5-11e1-b86c-0800200c9a66","Monograph"),
	REFERENCEBOOK("eda2d9e3-34c5-11e1-b86c-0800200c9a66","Referencebook"),
	TEXTBOOK("eda2d9e4-34c5-11e1-b86c-0800200c9a66","Textbook"),
	ENCYCLOPEDIA("eda2d9e5-34c5-11e1-b86c-0800200c9a66","Encyclopedia"),
	MANUAL("eda2d9e6-34c5-11e1-b86c-0800200c9a66","Manual"),
	OTHERBOOK("eda2d9e7-34c5-11e1-b86c-0800200c9a66","Otherbook"),
	JOURNAL("eda2d9e8-34c5-11e1-b86c-0800200c9a66","Journal"),
	JOURNAL_ARTICLE("eda2d9e9-34c5-11e1-b86c-0800200c9a66","Journal Article"),
	JOURNAL_ARTICLE_ABSTRACT("eda2d9ea-34c5-11e1-b86c-0800200c9a66","Journal Article Abstract"),
	JOURNAL_ARTICLE_REVIEW("eda2d9eb-34c5-11e1-b86c-0800200c9a66","Journal Article Review"),
	CONFERENCE_PROCEEDINGS("eda2d9ec-34c5-11e1-b86c-0800200c9a66","Conference Proceedings"),
	CONFERENCE_PROCEEDINGS_ARTICLE("eda2d9ed-34c5-11e1-b86c-0800200c9a66","Conference Proceedings Article"),
	LETTER("eda2d9ee-34c5-11e1-b86c-0800200c9a66","Letter"),
	LETTER_TO_EDITOR("eda2d9ef-34c5-11e1-b86c-0800200c9a66","Letter to Editor"),
	PHD_THESIS("eda2d9f0-34c5-11e1-b86c-0800200c9a66","PhD Thesis"),
	DOCTORAL_THESIS("eda2d9f1-34c5-11e1-b86c-0800200c9a66","Doctoral Thesis"),
	REPORT("eda2d9f2-34c5-11e1-b86c-0800200c9a66","Report"),
	SHORT_COMMUNICATION("eda2d9f3-34c5-11e1-b86c-0800200c9a66","Short Communication"),
	POSTER("eda2d9f4-34c5-11e1-b86c-0800200c9a66","Poster"),
	PRESENTATION("eda2d9f5-34c5-11e1-b86c-0800200c9a66","Presentation"),
	NEWSCLIPPING("eda2d9f6-34c5-11e1-b86c-0800200c9a66","Newsclipping"),
	COMMENTARY("eda2d9f7-34c5-11e1-b86c-0800200c9a66","Commentary"),
	ANNOTATION("eda2d9f8-34c5-11e1-b86c-0800200c9a66","Annotation"),
	TRANSLITERATION("640b32f5-da23-47e4-961d-46d106cc06b9","Transliteration"),
	TRANSLATION("f04aabeb-ee05-46b6-a7e8-1dc35bfd3c5d","Translation"),
	AUTHORED_BOOK("2522c045-5090-4da2-824c-583e039e23b3","Authored Book"),
	EDITED_BOOK("f5e38c52-d56a-4878-879c-31526788b19d","Edited Book"),
	CHAPTER_IN_BOOK("b7ddff91-81b9-42b1-8228-190329ea6557","Chapter in Book"),
	SCHOLARLY_EDITION("af3f2342-4724-4d04-8246-cc30f50a4f6d","Scholarly Edition"),
	CONFERENCE_CONTRIBUTION("43afa201-2979-42b0-b283-ed609058d90a","Conference Contribution"),
	WORKING_PAPER("3acbc6f9-8b04-4117-8222-f39c84c7b6c6","Working Paper"),
	ARTEFACT("93a40595-c066-4cb3-99a1-68f451e3a7cc","Artefact"),
	DEVICES_AND_PRODUCTS("2a10d453-7128-45dc-b5b0-040c0d06c7d7","Devices and products"),
	PERFORMANCE("2e0a25cd-88b5-4018-8de2-c12b3a702cfe","Performance"),
	EXHIBITION("71e46c84-243c-410f-9f61-63ec75323c8b","Exhibition"),
	PATENT_PUBLISHED_PATENT_APPLICATION("274e99d8-1e36-4b3e-a998-2a3384e79f64","Patent / published patent application"),
	COMPOSITION("6a49719d-1226-454b-bff5-04b6fd3f141c","Composition"),
	DESIGN("ab0efef8-6ef2-4509-ae10-8ccce30075d9","Design"),
	RESEARCH_REPORT_FOR_EXTERNAL_BODY("032f0d65-2461-492d-b718-2788ef5db869","Research report for external body."),
	CONFIDENTIAL_REPORT__FOR_EXTERNAL_BODY("ca47658a-322d-4010-94e6-81401dc5b565","Confidential Report (for external body)."),
	SOFTWARE("5b90f961-6489-4500-bb6a-5b60ead25a2d","Software"),
	WEBSITE_CONTENT("898beff1-5f9d-4b8f-b9d8-660a783fae9a","Website content"),
	DIGITAL_OR_VISUAL_MEDIA("3c610d3c-b62a-4889-811b-dc9dbe40b847","Digital or visual media"),
	RESEARCH_DATA_SETS_AND_DATABASES("b8da9b81-7cd8-4b33-88c5-28b41bbc49c9","Research data sets and databases"),
	OTHER("7eb3f358-bfc1-45d4-9ec6-b16d99f0ded6","Other"),
	JOURNAL_ISSUE("a85940d9-ad65-4a8d-ae54-23dda97c406e","Journal Issue"),
	SUPERVISED_STUDENT_PUBLICATIONS("b135c301-61d0-4d05-be98-e959f5c221dc","Supervised Student Publications"),
	ENCYCLOPEDIA_ENTRY("3f8f2c15-fbea-4b38-b517-3901378a9f1b","Encyclopedia Entry"),
	MAGAZINE_ARTICLE("d4753dda-e7a0-4837-ae7d-648a8d85b62c","Magazine Article"),
	DICTIONARY_ENTRY("71361e1a-03f1-4577-b91b-01cb87a2c280","Dictionary Entry"),
	RESEARCH_TOOL("a79aca4a-3a43-4809-92a6-9ce690dd7f70","Research Tool"),
	ONLINE_RESOURCE("db7bca87-379e-4854-a0d6-f9567226b1a6","Online Resource"),
	TEST("6915f869-e12e-42e8-b1b7-13bbea303d64","Test"),
	CONFERENCE_ABSTRACT("154e80ab-e825-4f7c-9430-bdf7ee971425","Conference Abstract"),
	CONFERENCE_POSTER("93aa5afc-19e5-4995-99b5-47ee8c80b3fc","Conference Poster"),
	MUSICAL_COMPOSITION("d7e9d33a-20d4-447c-bd3f-6774afa23f4e","Musical Composition"),
	MUSICAL_PERFORMANCE("849fcbfa-f863-4e80-b7b9-811ccc1fb9c1","Musical Performance"),
	RADIO_TV_PROGRAM("ca4665dc-d9da-49c3-950d-f95699e28b10","Radio/TV Program"),
	SCRIPT("488c227d-ade1-45c5-bf13-77cec1e5033c","Script"),
	SHORT_FICTION("68bade0c-2ac6-4dd9-834e-dec1583a607f","Short Fiction"),
	THEATRIC("c8b9bf7b-bb0c-493b-82aa-db9a5834f61e","Theatric"),
	VIDEO_RECORDING("b4a6438e-4bcb-4d8b-9363-4f6488861249","Video Recording"),
	VISUAL_ARTWORK("2dedf523-a6eb-4bfc-87e0-bc046e20f551","Visual Artwork"),
	SOUND_DESIGN("5d46488d-2952-4c31-bcca-84cd3f13fe7e","Sound Design"),
	SET_DESIGN("af08e1af-3d31-4b58-8ef1-8d5fc714a743","Set Design"),
	LIGHT_DESIGN("41555114-5fdb-4ee9-b5e7-b3acb574310d","Light Design"),
	CHOREOGRAPHY("77c9c66f-9e65-4876-8e82-34ac7c50582d","Choreography"),
	CURATORIAL_MUSEUM_EXHIBITIONS("8b5e666b-6121-4b4d-b446-9ed6ad7ed35c","Curatorial/Museum Exhibitions"),
	INTELLECTUAL_PROPERTY("64b9ce43-e5ed-4df2-86d5-01bc46939fd5","Intellectual Property"),
	LICENSE("2d8d91dc-00ef-4982-a6d2-0700b34b47fd","License"),
	DISCLOSURE("170136af-8bec-4b17-af16-c738633a3b96","Disclosure"),
	REGISTERED_COPYRIGHT("0f38dfac-b08c-4ed9-b627-df8f95d74bd5","Registered Copyright"),
	TRADEMARK("723f6119-ffac-4f4c-99d2-9c34eb644115","Trademark"),
	STANDARD_AND_POLICY("6b7fdebc-f169-4a7a-89b4-539ff69c5dcd","Standard and Policy"),
	TECHNICAL_STANDARD("c03694e5-f58b-4a37-83ff-5f8285c67f66","Technical Standard"),
	RESEARCH_TECHNIQUES("b8b97010-577d-4ba2-9195-0b6cba3f0866","Research Techniques"),
	INVENTION("76cf4c24-7f15-41b9-995f-889cec876b30","Invention"),
	LITIGATION("88478041-0fa4-4396-9246-6985ec0e9e6e","Litigation"),
	FAX("9931ac41-3864-11e1-b86c-0800200c9a66","Fax"),
	EMAIL("9931ac42-3864-11e1-b86c-0800200c9a66","Email"),
	PROFESSIONAL_EMAIL("35d43364-2160-4b6c-a487-5019458321e8","Professional Email"),
	PERSONAL_EMAIL("4523402a-0bae-4716-a5d7-77411b74d5f6","Personal Email"),
	SKYPE("20476135-bc75-40b4-b5f0-f05543e919c6","Skype"),
	TWITTER("95bff29c-338f-4790-80ac-c39ec3bc72f4","Twitter"),
	FACEBOOK("beb680a9-4504-417f-b444-65ff289c5952","Facebook"),
	LINKEDIN("48ed3997-8f3b-41bd-94c5-ba37df71c263","LinkedIn"),
	PHONE("9931ac44-3864-11e1-b86c-0800200c9a66","Phone"),
	PUBLIC_ACCESS("9931ac45-3864-11e1-b86c-0800200c9a66","Public Access"),
	CORPORATE_ACCESS("9931ac46-3864-11e1-b86c-0800200c9a66","Corporate Access"),
	PERSON_PROFESSIONAL_POSTAL_ADDRESS("6947fabb-a277-4f8f-b148-c6b41a936c57","Person Professional Postal Address"),
	MOBILEPHONE("44651010-00b1-4543-ae6f-b5983b704742","MobilePhone"),
	SMARTPHONE("abeddcc6-207b-4b9c-9cec-0de22087b728","Smartphone"),
	FIXEDPHONE("341b4fcc-9fe4-4760-a9c8-0f36ffa4d614","Fixedphone"),
	ORGANISATION_LEGAL_POSTAL_ADDRESS("3e480ccf-15cd-4e73-bdcc-d0d3c73a405c","Organisation Legal Postal Address"),
	ORGANISATION_FINANCIAL_POSTAL_ADDRESS("e103718b-c1b3-4cfd-ae53-d4b5c1d1fcae","Organisation Financial Postal Address"),
	LOGO("9931ac47-3864-11e1-b86c-0800200c9a66","Logo"),
	DISTRIBUTED("eda2d9f9-34c5-11e1-b86c-0800200c9a66","Distributed"),
	NETWORK("eda2d9fa-34c5-11e1-b86c-0800200c9a66","Network"),
	VIRTUAL("eda2d9fb-34c5-11e1-b86c-0800200c9a66","Virtual"),
	CLUSTER("eda2d9fc-34c5-11e1-b86c-0800200c9a66","Cluster"),
	SINGLE_LOCATION("eda2d9fd-34c5-11e1-b86c-0800200c9a66","Single location"),
	OWNER("eda2d9fe-34c5-11e1-b86c-0800200c9a66","Owner"),
	HOST("eda2d9ff-34c5-11e1-b86c-0800200c9a66","Host"),
	USER("eda2da00-34c5-11e1-b86c-0800200c9a66","User"),
	STAFF("eda2da01-34c5-11e1-b86c-0800200c9a66","Staff"),
	CONSTRUCTION("eda2da02-34c5-11e1-b86c-0800200c9a66","Construction"),
	DEVELOPMENT("eda2da03-34c5-11e1-b86c-0800200c9a66","Development"),
	UNDER_CONSTRUCTION("eda2da04-34c5-11e1-b86c-0800200c9a66","Under Construction"),
	BEING_UPGRADED("eda2da05-34c5-11e1-b86c-0800200c9a66","Being Upgraded"),
	IN_OPERATION("eda2da06-34c5-11e1-b86c-0800200c9a66","In Operation"),
	PROVISION("eda2da07-34c5-11e1-b86c-0800200c9a66","Provision"),
	CONSTRUCTION_COSTS("eda2da08-34c5-11e1-b86c-0800200c9a66","Construction Costs"),
	DESIGN_COSTS("eda2da09-34c5-11e1-b86c-0800200c9a66","Design Costs"),
	OPERATING_COSTS("eda2da0a-34c5-11e1-b86c-0800200c9a66","Operating Costs"),
	DOI("31d222b4-11e0-434b-b5ae-088119c51189","DOI"),
	PMCID("56f4fdbc-39a7-42cd-bd35-9d0d8c95f6da","PMCID"),
	ISI_NUMBER("008f9358-61db-46e2-8157-beb55e972aa6","ISI-Number"),
	SCOPUSAFFILIATIONID("fafa2259-304e-4aa4-8419-f84b9cf6f2eb","ScopusAffiliationID"),
	SCOPUSAUTHORID("24ddadbc-9b33-40c5-9d25-73b055f0183a","ScopusAuthorID"),
	ORCID("716bcc9a-c9dd-4b8b-b4ab-6c140e578ec3","ORCID"),
	INSTID("872e7b38-e11b-4b0f-b68b-6c6279c92e53","INSTID"),
	STAFFID("c0071785-549a-4379-a2af-d9a978ea3a1e","STAFFID"),
	HUSID("68e498fb-c8ee-4a08-a647-b191df5cac39","HUSID"),
	RESEARCHERID("b4a7caf0-5257-411e-accc-d1ee70d2f701","ResearcherID"),
	UKPRN("39436e26-6d68-4b5a-8ba1-d002a979fdea","UKPRN"),
	URI("f2dc329b-f47e-4876-9ceb-b190c19aca98","URI"),
	URL("7f65458e-00de-4eaf-8109-01e517790a2c","URL"),
	HR_ID("ba36c17a-c056-4d7b-aa26-b62bb04cdfc6","HR-ID"),
	PROJECT_MM_ID("b52eef12-0dca-4496-ae86-9389de0437f6","Project-MM-ID"),
	REPOSITORY_ID("c02711cd-7cfb-4b20-ba2e-15c8c1179a05","Repository-ID"),
	FINANCE_ID("7916dbe8-9264-4810-92df-7c21ab733338","Finance-ID"),
	CRIS_ID("708d9118-c4dd-4813-8ff7-b43bf0a493b0","CRIS-ID"),
	DNR("e093fb4c-4d5e-4602-8878-22e7dc360c36","DNR"),
	ISNI("c7e9afa5-02ce-4222-88f8-b717051fed39","ISNI"),
	UUID("e0d3ce71-2d85-4b6b-8103-636276d31c1d","UUID"),
	HANDLE("baaa59e1-745b-46e3-b068-aaa3dae9eef9","Handle"),
	VAT_IDENTIFICATION_NUMBER("634197d9-3a2e-4df7-b982-18b41a7e6f24","VAT Identification Number"),
	PASSPORT_NAME("64f0eb00-462d-4737-8033-7efac82decf3","Passport Name"),
	SHORT_NAME("bdcf213d-df3e-4af4-a2ea-69ca26e98cd4","Short Name"),
	INITIALS("5f3df96e-eb12-46b1-8458-c85914e2fc4c","Initials"),
	PRESENTED_NAME("55f90543-d631-42eb-8d47-d8d9266cbb26","Presented Name"),
	PREVIOUS_FAMILY_NAME("c54976a0-6793-4e62-b77d-7871ccb6ef0b","Previous Family Name"),
	COURSE("e88f9cfd-b786-40cb-9163-4718dbb865ff","Course"),
	COURSE_PRESENTATION("300592ee-e671-4054-a852-ab37b0d744c1","Course Presentation"),
	AWARD("17273adf-2529-49c3-a40a-21712d67128c","Award "),
	GRANT("4e664be9-100d-481c-b60f-b62a94078bac","Grant"),
	CONTRACT("125a3e36-a300-449f-abfa-11178d87ba63","Contract"),
	STAFFING_EXISTING("77a49137-eb32-4a30-9fff-14ce3eb4413f","Staffing Existing"),
	STAFFING_NEW("f81be4da-59bb-4718-949a-6e47b0fa2868","Staffing New"),
	CONSUMABLES("fa67d8ad-46eb-499a-9b9b-2b681b3d9485","Consumables"),
	OTHER_NON_STAFFING("5845512f-64ce-4cbe-b4c7-4c8794ab0242","Other Non-Staffing"),
	PAYMENT_TO_PARTNER("dd9bb430-17b3-4064-bd1f-528237bd4e48","Payment-To-Partner"),
	ESTATES("fb8a8939-0659-4cdf-b186-f8430566e845","Estates"),
	INDIRECT_COSTS("6d81aa21-e667-4778-bc97-c59e0cc3fa18","Indirect Costs"),
	FEC_BALANCING_AMOUNT("b2aeb46d-3ae2-4df6-aaad-079a339da9d2","fEC Balancing Amount"),
	INCOME_BUDGET("7655a603-a4d7-4b92-8c87-d7e767d2c7a7","Income-Budget"),
	EXPENDITURE_BUDGET("d2c2d808-bd02-4ffc-8a76-76c3d0c9cc1f","Expenditure-Budget"),
	INCOME_COMMITMENT("df1c9f14-6b87-43a1-9a5a-2d0ade88ad0b","Income-Commitment"),
	EXPENDITURE_COMMITMENT("8db551b3-e630-48a0-9164-d177f4ec3602","Expenditure-Commitment"),
	INCOME_ACTUAL("df27417c-bb3c-4881-9a46-cc6403b2ca39","Income-Actual"),
	EXPENDITURE_ACTUAL("fe050c5b-2760-4c67-b5b6-6252257b7c61","Expenditure-Actual"),
	IN_PREPARATION("1bb29e6d-d282-415f-920d-9b6148933a35","In Preparation"),
	SUBMITTED_FOR_CONSIDERATION("1c774414-3a42-4e4c-b3c5-04b89202c40f","Submitted for Consideration"),
	IN_PRESS("da636eb4-efe2-4112-a4ee-7ce4a99e2374","In Press"),
	PUBLISHED("e601872f-4b7e-4d88-929f-7df027b226c9","Published"),
	UNPUBLISHED("24906a3a-1edd-40f0-aeec-5f0bf4312086","Unpublished"),
	YES("df943548-c67e-4c96-8c4f-1c0aa144b1c0","Yes"),
	NO("0c7c83d0-5513-4eaa-b5cf-d01374c3d2eb","No"),
	UNKNOWN("22b56ddc-87e8-4023-ab56-e661dcb8ffd3","Unknown"),
	PENDING_GRADING("19258084-7068-4be1-8cfd-171952060f0c","Pending Grading"),
	STAR_4("f9237eb5-a5c9-433f-887d-e2eac703bc18","4-Star"),
	STAR_3("9e93db57-3349-4bb9-bfba-9481302b4784","3-Star"),
	STAR_2("7f1998ce-ddfa-4ece-af02-2eed9a48c8d2","2-Star"),
	STAR_1("89644214-e41f-4c30-befb-ab5d9443c08b","1-Star"),
	UNCLASSIFIED("7ea05f8e-bd27-4f33-bfa4-54dfb3e6f905","Unclassified"),
	GOLD_OPEN_ACCESS("98072417-c98b-46dc-99aa-364bb672cd63","Gold Open Access"),
	GREEN_OPEN_ACCESS("7cfe736a-73bb-4324-b3dd-34228e5dbe7d","Green Open Access"),
	DATA_STORAGE("59c67182-270e-4ade-8edb-9cdf16d2e1b1","Data Storage"),
	CHECKED("c3c8c96f-cc0f-47e6-9c6d-4f86949ab984","Checked"),
	UNCHECKED("9b5e9d79-c332-40cb-b888-8a37bdef9f1f","Unchecked"),
	USAGE("48d9e3c5-4c9f-48a4-a585-c27b9f75d61b", "Usage"),
	DEFAULT("bcc9792b-d8f9-4e70-af7c-f3889e2228e0", "Default");
	
	/**
	 * Universally unique identifier (UUID) of type 4.
	 */
	private String uuid;

	/**
	 * The name.
	 */
	private String name;
	
	/**
	 * The entity class.
	 */
	private Class<? extends CerifEntity> entityClass;
	
	/**
	 * Constructor.
	 * @param uuid Universally unique identifier (UUID) of type 4.
	 * @param name The name.
	 */
	private ClassEnum(String uuid, String name) {
		this.uuid = uuid;
		this.name = name;
	}
	
	/**
	 * Constructor.
	 * @param uuid Universally unique identifier (UUID) of type 4.
	 * @param name The name.
	 * @param entityClass The entity class.
	 */
	private ClassEnum(String uuid, String name, Class<? extends CerifEntity> entityClass) {
		this.uuid = uuid;
		this.name = name;
		this.entityClass = entityClass;
	}

	/**
	 * @return the uuid
	 */
	public String getUuid() {
		return uuid;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Returns the entity class.
	 * @return a class.
	 */
	public Class<? extends CerifEntity> getEntityClass() {
		return entityClass;
	}
	
	
	public static ClassEnum fromUuid(String uuid) {
		for (ClassEnum c : ClassEnum.values()) {
			if (c.getUuid()!=null) {
				if (c.uuid.equals(uuid)) {
					return c;
				}
			}
		}
		return null;
	}

	/**
	 * Return a string representation of this code.
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("ClassEnum [");
		sb.append("uuid=" + uuid + ", name=" + name);
		sb.append("]");
		return sb.toString();
	}


}
