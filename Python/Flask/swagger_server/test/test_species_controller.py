# coding: utf-8

from __future__ import absolute_import

from flask import json
from six import BytesIO

from swagger_server.models.species import Species  # noqa: E501
from swagger_server.models.species_list import SpeciesList  # noqa: E501
from swagger_server.test import BaseTestCase


class TestSpeciesController(BaseTestCase):
    """SpeciesController integration test stubs"""

    def test_add_species(self):
        """Test case for add_species

        Add a species to the database
        """
        body = Species()
        response = self.client.open(
            '/species',
            method='POST',
            data=json.dumps(body),
            content_type='application/json')
        self.assert200(response,
                       'Response body is : ' + response.data.decode('utf-8'))

    def test_delete_species(self):
        """Test case for delete_species

        Delete a species from the database
        """
        response = self.client.open(
            '/species/{name}'.format(name='name_example'),
            method='DELETE')
        self.assert200(response,
                       'Response body is : ' + response.data.decode('utf-8'))

    def test_get_eye_color(self):
        """Test case for get_eye_color

        Get a list of species with the specified eye color
        """
        response = self.client.open(
            '/species/eye/{eye_color}'.format(eye_color='eye_color_example'),
            method='GET')
        self.assert200(response,
                       'Response body is : ' + response.data.decode('utf-8'))

    def test_get_species(self):
        """Test case for get_species

        Get a species from the database
        """
        response = self.client.open(
            '/species/{name}'.format(name='name_example'),
            method='GET')
        self.assert200(response,
                       'Response body is : ' + response.data.decode('utf-8'))

    def test_update_species(self):
        """Test case for update_species

        Update an existing species
        """
        body = Species()
        response = self.client.open(
            '/species',
            method='PUT',
            data=json.dumps(body),
            content_type='application/json')
        self.assert200(response,
                       'Response body is : ' + response.data.decode('utf-8'))


if __name__ == '__main__':
    import unittest
    unittest.main()
