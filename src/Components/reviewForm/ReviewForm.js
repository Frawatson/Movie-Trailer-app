import { Button, Form } from 'react-bootstrap';

/**
 * Renders a review form component.
 *
 * @param {function} handleSubmit - The function to handle form submission.
 * @param {object} revText - The reference to the textarea element.
 * @param {string} labelText - The label text for the textarea.
 * @param {string} defaultValue - The default value for the textarea.
 * @return {JSX.Element} The rendered review form component.
 */
const ReviewForm = ({handleSubmit,revText,labelText,defaultValue}) => {

    return (

        <Form>
            <Form.Group className="mb-3" controlId="exampleForm.ControlTextarea1">
                <Form.Label>{labelText}</Form.Label>
                <Form.Control ref={revText} as="textarea" rows={3} defaultValue={defaultValue} />
            </Form.Group>
            <Button variant="outline-info" onClick={handleSubmit}>Submit</Button>
        </Form>   

    )
}

export default ReviewForm