# coding: utf-8

from __future__ import absolute_import

from flask import json
from six import BytesIO

from swagger_server.models.character import Character  # noqa: E501
from swagger_server.models.character_list import CharacterList  # noqa: E501
from swagger_server.test import BaseTestCase


class TestCharactersController(BaseTestCase):
    """CharactersController integration test stubs"""

    def test_add_character(self):
        """Test case for add_character

        Add a character to the database
        """
        body = Character()
        response = self.client.open(
            '/character',
            method='POST',
            data=json.dumps(body),
            content_type='application/json')
        self.assert200(response,
                       'Response body is : ' + response.data.decode('utf-8'))

    def test_delete_character(self):
        """Test case for delete_character

        Delete a character from the database
        """
        response = self.client.open(
            '/character/{name}'.format(name='name_example'),
            method='DELETE')
        self.assert200(response,
                       'Response body is : ' + response.data.decode('utf-8'))

    def test_get_character(self):
        """Test case for get_character

        Get a character from the database
        """
        response = self.client.open(
            '/character/{name}'.format(name='name_example'),
            method='GET')
        self.assert200(response,
                       'Response body is : ' + response.data.decode('utf-8'))

    def test_get_mass(self):
        """Test case for get_mass

        Get a list of all charcaters with mass greater than or equal to the specified mass value
        """
        response = self.client.open(
            '/character/mass/{mass}'.format(mass=56),
            method='GET')
        self.assert200(response,
                       'Response body is : ' + response.data.decode('utf-8'))

    def test_update_character(self):
        """Test case for update_character

        Update an existing Character object
        """
        body = Character()
        response = self.client.open(
            '/character',
            method='PUT',
            data=json.dumps(body),
            content_type='application/json')
        self.assert200(response,
                       'Response body is : ' + response.data.decode('utf-8'))


if __name__ == '__main__':
    import unittest
    unittest.main()
