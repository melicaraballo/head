package org.mifos.platform.questionnaire;

@SuppressWarnings("PMD.AtLeastOneConstructor")
public class QuestionnaireConstants {
    public static final String QUESTION_TITLE_NOT_PROVIDED = "questionnaire.error.QuestionTitleNotProvided";
    public static final String QUESTION_TYPE_NOT_PROVIDED = "questionnaire.error.QuestionTypeNotProvided";
    public static final String QUESTION_TITLE_DUPLICATE = "questionnaire.error.DuplicateQuestion";
    public static final String QUESTION_TITILE_MATCHES_EXISTING_QUESTION = "questionnaire.error.QuestionTitleMatchesExistingQuestion";
    public static final String QUESTION_GROUP_TITLE_NOT_PROVIDED = "questionnaire.error.QuestionGroupTitleNotProvided";
    public static final String QUESTION_GROUP_SECTION_NOT_PROVIDED = "questionnaire.error.QuestionGroupSectionNotProvided";
    public static final String QUESTION_GROUP_NOT_FOUND = "questionnaire.error.questionGroup.notFound";
    public static final String INVALID_QUESTION_GROUP_ID = "questionnaire.error.questionGroup.invalid";
    public static final String QUESTION_NOT_FOUND = "questionnaire.error.question.notFound";
    public static final String INVALID_QUESTION_ID = "questionnaire.error.question.invalid";
    public static final String INVALID_EVENT_SOURCE = "questionnaire.error.InvalidEventSourceProvided";
    public static final String NO_QUESTIONS_FOUND_IN_SECTION = "questionnaire.error.no.questions.found.in.section";
    public static final String DUPLICATE_QUESTION_FOUND_IN_SECTION = "questionnaire.error.duplicate.question.found.in.section";
    public static final String DEFAULT_APPLIES_TO_OPTION = "--select one--";
    public static final String NUMERIC_QUESTION_HAS_BAD_ANSWER = "questionnaire.error.numeric.question.has.bad.answer";
    public static final String NO_ANSWERS_PROVIDED = "questionnaire.error.no.answers.provided";
    public static final String GENERIC_VALIDATION = "questionnaire.error.generic.validation";
    public static final String INVALID_NUMERIC_BOUNDS = "questionnaire.error.invalid.numeric.bounds";
    public static final String QUESTION_GROUP_TITLE_TOO_BIG = "questionnaire.error.QuestionGroupTitleTooBig";
    public static final String QUESTION_GROUP_TITLE_DUPLICATE = "questionnaire.error.QuestionGroupTitleDuplicate";
    public static final String SECTION_TITLE_NOT_PROVIDED = "questionnaire.error.SectionTitleNotProvided";
    public static final String SECTION_TITLE_DUPLICATE = "questionnaire.error.SectionTitleDuplicate";
    public static final String SECTION_NAME_TOO_BIG = "questionnaire.error.SectionNameTooBig";
    public static final String QUESTION_TITLE_TOO_BIG = "questionnaire.error.QuestionTitleTooBig";
    public static final String SECTION_ORDER_NOT_PROVIDED = "questionnaire.error.SectionOrderNotProvided";
    public static final String SECTION_ORDER_DUPLICATE = "questionnaire.error.SectionOrderDuplicate";
    public static final String QUESTION_ORDER_NOT_PROVIDED = "questionnaire.error.QuestionOrderNotProvided";
    public static final String QUESTION_ORDER_DUPLICATE = "questionnaire.error.QuestionOrderDuplicate";
    public static final String QUESTION_CHOICES_INSUFFICIENT = "questionnaire.error.QuestionChoicesInsufficient";
    public static final String QUESTION_CHOICES_INVALID = "questionnaire.error.QuestionChoicesInvalid";
    public static final String PPI_SURVEY_UPLOAD_FAILED = "questionnaire.error.PPISurveyUploadFailed";
    public static final String PPI_SURVEY_CONVERSION_ERROR = "questionnaire.error.PPISurveyConversionError";
    public static final String PPI_SURVEY_PARSE_ERROR = "questionnaire.error.PPISurveyParseError";
    public static final String PPI_SURVEY_FILE_NOT_FOUND = "questionnaire.error.PPISurveyFileNotFound";
    public static final String FETCH_PPI_XMLS_FAILED = "questionnaire.error.FetchPPIXmlsFailed";
    public static final String FETCH_PPI_COUNTRY_XML_FAILED = "questionnaire.error.FetchPPICountryXmlFailed";
    public static final int MAX_LENGTH_FOR_TITILE = 50;
    public static final int MAX_CHOICES_FOR_QUESTION = 2;
    public static final String PPI_SURVEY_FILE_PREFIX = "PPISurvey";
    public static final String PPI_SURVEY_FILE_EXT = ".xml";
    public static final String SELECT_ONE = "--select one--";
    public static final String DEFAULT_SECTION_NAME = "Misc";
    public static final String DEFAULT_EVENT_FOR_CUSTOM_FIELD = "Create";
    public static final String QUESTION_GROUP_TITLE_FOR_ADDITIONAL_FIELDS = "Additional Fields for %s";
}
